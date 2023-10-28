package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.ReservaEntity;

import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query(value = "SELECT pra_id, pra_nome, pra_preco_venda FROM pra_prato", nativeQuery = true)
    List<Object[]> getPratos();

}
