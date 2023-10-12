package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.ItemPedidoEntity;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {
    
}
