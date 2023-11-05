package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.EstoqueEntity;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {

    @Query(
        value = "SELECT est_nome, est_qtd_estoque, est_nivel_minimo FROM est_estoque WHERE est_qtd_estoque <= est_nivel_minimo",
        nativeQuery = true
    )
    List<Object[]> avisoNivelBaixo();

}
