package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.EstoqueEntity;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {

    public void executarTrigger();

}
