package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.service.EstoqueService;

@RestController
@CrossOrigin
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping("/avisoNivelBaixo")
    public List<Object[]> avisoNivelBaixo() {
        return estoqueService.avisoNivelBaixo();
    }

}

