package api5.cloudKitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public List<Object[]> avisoNivelBaixo() {
        return estoqueRepository.avisoNivelBaixo();
    }

    public List<Object[]> nomeProdutoFornecedor() {
        return estoqueRepository.nomeProdutoFornecedor();
    }

}
