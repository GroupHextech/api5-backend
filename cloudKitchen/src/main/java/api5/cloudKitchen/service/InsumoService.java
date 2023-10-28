package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import api5.cloudKitchen.entity.EstoqueEntity;
import api5.cloudKitchen.entity.FornecedorEntity;
import api5.cloudKitchen.entity.InsumoEntity;
import api5.cloudKitchen.repository.InsumoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    public ResponseEntity<String> uploadCSV(MultipartFile file) throws CsvException {
        if (file.isEmpty()) {
            return new ResponseEntity<>(
                "Selecione um arquivo CSV para fazer upload.",
                HttpStatus.BAD_REQUEST
            );
        }

        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            CSVReader csvReader = new CSVReader(reader)
        ) {
            List<String[]> csvData = csvReader.readAll();

            for (String[] row : csvData) {
                if (row.length != 7) {
                    return new ResponseEntity<>(
                        "O arquivo CSV deve conter 7 colunas.",
                        HttpStatus.BAD_REQUEST
                    );
                }
                try {
                    InsumoEntity insumo = new InsumoEntity();
                    insumo.setInsQtdEntrada(Float.parseFloat(row[0]));
                    insumo.setInsValidade(Date.valueOf(row[1]));
                    insumo.setInsDataHoraCompra(LocalDateTime.parse(row[2]));
                    insumo.setInsValorCompra(Float.parseFloat(row[3]));
                    insumo.setForId(FornecedorEntity.parse(row[4]));
                    insumo.setEstId(EstoqueEntity.parse(row[5]));

                    insumoRepository.save(insumo);
                } catch (NumberFormatException | DateTimeParseException e) {
                    return new ResponseEntity<>(
                        "Erro ao converter dados no arquivo CSV.",
                        HttpStatus.BAD_REQUEST
                    );
                }
            }

            return new ResponseEntity<>(
                "Upload e processamento de arquivo CSV bem-sucedidos.",
                HttpStatus.OK
            );
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                "Ocorreu um erro durante o processamento do arquivo CSV.",
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
