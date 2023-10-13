package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.FornecedorEntity;

public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
    
}
