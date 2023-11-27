package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.service.FornecedorService;

@RestController
@CrossOrigin
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;
    
    @GetMapping("/all")
    public List<Object[]> getFornecedor() {
        return fornecedorService.getFornecedor();
    }

}
