package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    @Query(value = "SELECT * FROM log_login", nativeQuery = true)
    List<Object[]> login();
}
