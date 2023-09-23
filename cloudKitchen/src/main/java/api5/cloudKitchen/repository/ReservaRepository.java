package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>{
    
}
