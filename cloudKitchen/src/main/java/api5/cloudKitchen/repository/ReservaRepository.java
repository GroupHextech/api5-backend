package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.ReservaEntity;

import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query(value = "SELECT * FROM v_mesa_status_por_data", nativeQuery = true)
    List<Object[]> getMesaStatusPorData();

}
