package api5.cloudKitchen.DTO;

import java.sql.Timestamp;
import java.util.List;

import api5.cloudKitchen.entity.ReservaEntity;
import lombok.Data;

@Data
public class PedidoResponseDTO {
    private Long pedId;
    private Timestamp pedHoraPedido;
    private Float pedValorTotal;
    private ReservaEntity reserva;

    private List<ItemPedidoResponseDTO> itens;
}
