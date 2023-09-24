package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.RestauranteEntity;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {

    @Query(value = "SELECT media_desempenho FROM v_media_desempenho_restaurante", nativeQuery = true)
    Double consultarMediaDesempenhoRestaurante();

    @Query(value = "SELECT nota, quantidade FROM v_quantidade_notas_restaurante", nativeQuery = true)
    List<Object[]> consultarQuantidadeNotasRestaurante();

}
