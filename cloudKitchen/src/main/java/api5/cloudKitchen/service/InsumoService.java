package api5.cloudKitchen.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api5.cloudKitchen.entity.EstoqueEntity;
import api5.cloudKitchen.entity.FornecedorEntity;
import api5.cloudKitchen.entity.InsumoEntity;
import api5.cloudKitchen.repository.InsumoRepository;
@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Transactional
    public void processarCSV(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    InsumoEntity insumo = new InsumoEntity();
                    
                    insumo.setInsValorCompra(Float.parseFloat(data[2]));

                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Ajuste o formato conforme seu CSV
                        java.util.Date parsedDate = dateFormat.parse(data[4]);
                        Date sqlDate = new Date(parsedDate.getTime());
                        insumo.setInsValidade(sqlDate);
                    } catch (ParseException e) { 
                        e.printStackTrace();
                    }
                    insumo.setInsDataHoraCompra(LocalDateTime.parse(data[3]));
                    insumo.setInsQtdEntrada(Float.parseFloat(data[5]));
                    
                    FornecedorEntity fornecedor = new FornecedorEntity();
                    fornecedor.setForId(Long.parseLong(data[1]));
                    insumo.setForId(fornecedor);
                    
                    EstoqueEntity estoque = new EstoqueEntity();
                    estoque.setEstId(Long.parseLong(data[0]));
                    insumo.setEstId(estoque);

                    insumoRepository.save(insumo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}