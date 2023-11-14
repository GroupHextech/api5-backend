package api5.cloudKitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.entity.LoginEntity;
import api5.cloudKitchen.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginEntity autenticar() throws Exception {

        LoginEntity loginEntity = new LoginEntity();
        
        return loginEntity;

    }
}
