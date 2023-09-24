package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.entity.InsumoEntity;
import api5.cloudKitchen.repository.InsumoRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/insumos")
public class InsumoController {

    @Autowired
    private InsumoRepository insumoRepository;

    @GetMapping
    public List<InsumoEntity> listarInsumos() {
        return insumoRepository.findAll();
    }

}