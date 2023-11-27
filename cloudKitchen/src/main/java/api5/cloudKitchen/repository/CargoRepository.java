package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
    
}
