package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long>{
    
}
