package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    @Query(value = "SELECT * FROM ped_pedido", nativeQuery = true)
    List<PedidoEntity> consultarMediaDesempenhoRestaurante();

    @Query(value = "SELECT * FROM pra_prato", nativeQuery = true)
    List<Object[]> consultarQuantidadeNotasRestaurante();

}
