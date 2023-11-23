/*
package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import api5.cloudKitchen.entity.LoginEntity;
import api5.cloudKitchen.security.JwtUtils;
import api5.cloudKitchen.security.Login;
import api5.cloudKitchen.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
	private LoginService loginService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping()
    public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
        Authentication auth = new UsernamePasswordAuthenticationToken(
            login.getLoginUsuario(), login.getSenhaUsuario()
        );
        auth = authManager.authenticate(auth);
        
        login.setSenhaUsuario(null);
        login.setToken(JwtUtils.generateToken(auth));
        login.setAutorizacao(auth.getAuthorities().iterator().next().getAuthority());
        List<LoginEntity> samples = loginService.findByLoginUsuario(login.getLoginUsuario());
        LoginEntity sample = samples.get(0);
        login.setIdUsuario(sample.getLogId());
        login.setSenhaUsuario(sample.getLogPassword());
        return login;
    }

}
 */