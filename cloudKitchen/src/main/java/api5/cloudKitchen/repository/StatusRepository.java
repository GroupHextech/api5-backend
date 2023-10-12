package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
    
}
