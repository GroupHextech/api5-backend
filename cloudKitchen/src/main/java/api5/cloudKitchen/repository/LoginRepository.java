package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

}
