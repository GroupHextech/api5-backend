package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.ReservaEntity;

import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query(value = "SELECT pra_id, pra_nome, pra_preco_venda FROM pra_prato", nativeQuery = true)
    List<Object[]> getPratos();

    @Query(
        value = "SELECT res_id, res_nome, res_telefone, res_data_hora, res_mesa FROM res_reserva ORDER BY res_data_hora",
        nativeQuery = true
    )
    List<Object[]> getAllReserva();

    @Query(
        value = "SELECT res_id, res_nome, res_telefone, res_data_hora, res_mesa FROM res_reserva WHERE sta_id = 1",
        nativeQuery = true
    )
    List<Object[]> getReservaLivre();

    @Query(
        value = "SELECT res_id, res_nome, res_telefone, res_data_hora, res_mesa FROM res_reserva WHERE sta_id = 1",
        nativeQuery = true
    )
    List<Object[]> getReservaOcupada();

    @Query(
        value = "SELECT res_id, res_nome, res_telefone, res_data_hora, res_mesa FROM res_reserva WHERE sta_id = 1",
        nativeQuery = true
    )
    List<Object[]> getReservaReservada();

}
