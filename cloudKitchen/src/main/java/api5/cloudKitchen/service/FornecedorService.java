package api5.cloudKitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public List<Object[]> getFornecedor() {
        return fornecedorRepository.getFornecedor();
    }

}
