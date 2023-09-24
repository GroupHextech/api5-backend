package api5.cloudKitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api5.cloudKitchen.service.InsumoService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/insumo")
public class InsumoController {

    private final InsumoService insumoService;

    @Autowired
    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    // Endpoint para obter detalhes de insumo e fornecedor
    @GetMapping("/detalhes")
    public List<Object[]> getDetalhesInsumoFornecedor() {
        return insumoService.getDetalhesInsumoFornecedor();
    }

}