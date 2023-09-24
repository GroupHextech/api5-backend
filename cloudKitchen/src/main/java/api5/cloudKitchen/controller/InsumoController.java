package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api5.cloudKitchen.service.InsumoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/insumos")
public class InsumoController {

    private final InsumoService insumoService;

    @Autowired
    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping
    public List<Object[]> consultarInsumos() {
        return insumoService.consultarInsumos();
    }

    @GetMapping("/entradas-saidas")
    public List<Object[]> consultarInsumosDiferenca() {
        return insumoService.consultarInsumosDiferenca();
    }

}
