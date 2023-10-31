package api5.cloudKitchen.DTO;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class PedidoRequestDTO {
    private Timestamp pedHoraPedido;
    private Timestamp pedHoraEntregue;
    private Float pedValorTotal;
    private Integer pedAvaliacao;
    private Long resId;

    private List<ItemPedidoRequestDTO> itens;
}
