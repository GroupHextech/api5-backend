package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.InsumoEntity;

public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {

    @Query(value = "ins_insumo", nativeQuery = true)
    List<Object[]> consultarInsumos();

    @Query(value = "SELECT * FROM fun_funcionario", nativeQuery = true)
    List<Object[]> consultarInsumosDiferenca();

}

    
