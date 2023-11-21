package api5.cloudKitchen.mapper;

import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.LoginDTO;
import api5.cloudKitchen.entity.LoginEntity;

@Component
public class LoginMapper {

    public LoginEntity map(LoginDTO loginDTO) {

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogUsername(loginDTO.getLogUsername());
        loginEntity.setLogPassword(loginDTO.getLogPassword());
        loginEntity.setPmsId(loginDTO.getPmsId());

        return loginEntity;

    }

    public LoginDTO map(LoginEntity loginEntity) {

        LoginDTO loginRequestDTO = new LoginDTO();
        loginRequestDTO.setLogUsername(loginEntity.getLogUsername());
        loginRequestDTO.setLogPassword(loginEntity.getLogPassword());
        loginRequestDTO.setPmsId(loginEntity.getPmsId());

        return loginRequestDTO;

    }

}
