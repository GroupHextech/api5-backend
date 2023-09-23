package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.RestauranteEntity;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long>{
    
}
