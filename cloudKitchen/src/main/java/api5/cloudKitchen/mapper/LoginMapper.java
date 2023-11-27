package api5.cloudKitchen.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.LoginRequestDTO;
import api5.cloudKitchen.DTO.LoginResponseDTO;
import api5.cloudKitchen.DTO.PermissaoDTO;
import api5.cloudKitchen.entity.LoginEntity;
import api5.cloudKitchen.entity.PermissaoEntity;
import api5.cloudKitchen.repository.PermissaoRepository;

@Component
public class LoginMapper {

    @Autowired
    PermissaoRepository permissaoRepository;

    @Autowired
    PermissaoMapper permissaoMapper;

    public LoginEntity map(LoginRequestDTO loginRequestDTO) throws Exception {

        LoginEntity loginEntity = new LoginEntity();

        Optional<PermissaoEntity> permissao = permissaoRepository.findById(loginRequestDTO.getPmsId());

        if(permissao.isEmpty()){
            throw new Exception("Permissao não encontrada");
        }

        loginEntity.setLogUsername(loginRequestDTO.getLogUsername());
        loginEntity.setLogPassword(loginRequestDTO.getLogPassword());
        loginEntity.setPmsId(permissao.get());

        return loginEntity;

    }

    public LoginResponseDTO map(LoginEntity loginEntity) {

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

        PermissaoDTO permissao = permissaoMapper.map(loginEntity.getPmsId());

        loginResponseDTO.setLogUsername(loginEntity.getLogUsername());
        loginResponseDTO.setLogPassword(loginEntity.getLogPassword());
        loginResponseDTO.setPmsId(permissao);

        return loginResponseDTO;

    }

}
