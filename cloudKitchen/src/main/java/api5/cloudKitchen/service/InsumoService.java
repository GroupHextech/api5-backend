package api5.cloudKitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.InsumoRepository;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    public InsumoRepository getInsumoRepository() {
        return insumoRepository;
    }

    public void setInsumoRepository(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public static List<InsumoRepository> findAll() {
        return null;
    }

}