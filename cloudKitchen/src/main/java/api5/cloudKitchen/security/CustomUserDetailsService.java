package api5.cloudKitchen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.entity.LoginEntity;
import api5.cloudKitchen.repository.LoginRepository;

@Service
public class CustomUserDetailsService {

    @Autowired
    private LoginRepository loginRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginEntity loginEntity = loginRepository.findByUsername(username);

        if(loginEntity == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
    }
}
