package api5.cloudKitchen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    public Optional<LoginEntity> findByUsername(String username);

    public List<LoginEntity> findByUsernameList (String username);

}
