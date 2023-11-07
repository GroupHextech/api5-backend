package api5.cloudKitchen.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.repository.FuncionarioRepository;
import api5.cloudKitchen.service.PedidoService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    
    @PostMapping()
    public FuncionarioRepository autenticar(@RequestBody) throws JsonProcessingException {

    }
}
