package api5.cloudKitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.service.InsumoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/insumo")
public class InsumoController {

    @Autowired
    public InsumoService insumoService;

}