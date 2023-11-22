package api5.cloudKitchen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.DTO.LoginResponseDTO;
import api5.cloudKitchen.entity.LoginEntity;
import api5.cloudKitchen.entity.PermissaoEntity;
import api5.cloudKitchen.mapper.LoginMapper;
import api5.cloudKitchen.repository.LoginRepository;
import api5.cloudKitchen.repository.PermissaoRepository;

@Service
public class LoginService {

	@Autowired
	PermissaoRepository permissaoRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginMapper loginMapper;

    public LoginEntity atualizarUsuario(String username, LoginResponseDTO loginResponseDTO) {

		Optional<LoginEntity> optionalLogin = loginRepository.findByUsername(username);
		System.err.println(optionalLogin);
		System.err.println(loginResponseDTO);

		if (optionalLogin.isPresent()) {

			LoginEntity loginEntity = optionalLogin.get();
			loginEntity.setLogUsername(loginResponseDTO.getLogUsername());

			Optional<PermissaoEntity> optionalPermissao = permissaoRepository
				.findById(loginMapper.map(loginResponseDTO.getPmsId()));

			if (optionalPermissao.isPresent()) {
				PermissaoEntity.setPmsId(optionalPermissao.get());
			}

			return loginRepository.save(loginEntity);

		} else {
			return null;
		}

    }

}
