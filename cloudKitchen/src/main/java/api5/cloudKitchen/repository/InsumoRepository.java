package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.InsumoEntity;

import java.util.List;

public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {

    @Query(
        value = "SELECT * FROM v_detalhes_insumo_fornecedor", nativeQuery = true
    )
    List<Object[]> getDetalhesInsumos();
}