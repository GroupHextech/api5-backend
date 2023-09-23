package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.InsumoRepository;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

}