package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.entity.InsumoEntity;
import api5.cloudKitchen.repository.InsumoRepository;

import java.util.List;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    // Método para obter todos os insumos
    public List<InsumoEntity> getAllInsumos() {
        return insumoRepository.findAll();
    }

    // Método para obter detalhes de insumo e fornecedor
    public List<Object[]> getDetalhesInsumoFornecedor() {
        return insumoRepository.getDetalhesInsumos();
    }

}