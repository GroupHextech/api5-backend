package api5.cloudKitchen.mapper;

import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.LoginRequestDTO;
import api5.cloudKitchen.entity.LoginEntity;

@Component
public class LoginMapper {

    public LoginEntity map(LoginRequestDTO loginRequestDTO) {

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogUsername(loginRequestDTO.getLogUsername());
        loginEntity.setLogPassword(loginRequestDTO.getLogPassword());
        return loginEntity;

    }

    public LoginRequestDTO map(LoginEntity loginEntity) {

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setLogUsername(loginEntity.getLogUsername());
        loginRequestDTO.setLogPassword(loginEntity.getLogPassword());
        return loginRequestDTO;

    }

}
