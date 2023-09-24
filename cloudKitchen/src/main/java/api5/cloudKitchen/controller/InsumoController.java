package api5.cloudKitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/consultar-insumos")
    public List<Object[]> consultarInsumos() {
        return insumoService.consultarInsumos();
    }

    @GetMapping("/consultar-insumos-diferenca")
    public List<Object[]> consultarInsumosDiferenca() {
        return insumoService.consultarInsumosDiferenca();
    }

}
