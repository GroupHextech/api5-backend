package api5.cloudKitchen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.DTO.LoginDTO;
import api5.cloudKitchen.entity.LoginEntity;
import api5.cloudKitchen.entity.PermissaoEntity;
import api5.cloudKitchen.mapper.LoginMapper;
import api5.cloudKitchen.repository.LoginRepository;
import api5.cloudKitchen.repository.PermissaoRepository;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginMapper loginMapper;

    public LoginEntity atualizarUsuario(String username, LoginDTO loginDTO) {

		Optional<LoginEntity> optionalLogin = loginRepository.findByUsername(username);
		System.err.println(optionalLogin);
		System.err.println(loginDTO);

		if (optionalLogin.isPresent()) {

			LoginEntity loginEntity = optionalLogin.get();
			loginEntity.setLogUsername(loginDTO.getLogUsername());

			Optional<LoginEntity> optionalPermissao = loginRepository
				.findByPermissaoId(loginDTO.getPmsId());

			if (optionalPermissao.isPresent()) {
				loginEntity.setPmsId(optionalPermissao.get());
			}

			return loginRepository.save(loginEntity);

		} else {
			return null;
		}

    }

}
