package api5.cloudKitchen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<PedidoEntity> findById(Long pedId);

}
