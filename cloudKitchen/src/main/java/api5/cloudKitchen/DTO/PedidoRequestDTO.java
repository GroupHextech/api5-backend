package api5.cloudKitchen.DTO;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PedidoRequestDTO {
    private Timestamp pedHoraPedido;
    private Float pedValorTotal;
    private Long resId;

    private Long praId;
    private Long pedIdItem;
    private Long iteQuantidade;
}
