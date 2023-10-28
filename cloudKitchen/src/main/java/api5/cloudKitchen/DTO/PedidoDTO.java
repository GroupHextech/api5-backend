package api5.cloudKitchen.DTO;

import java.sql.Timestamp;

import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.entity.PratoEntity;
import api5.cloudKitchen.entity.ReservaEntity;
import lombok.Data;

@Data
public class PedidoDTO {
    private Long pedId;
    private Timestamp pedHoraPedido;
    private Float pedValorTotal;
    private ReservaEntity resId;

    private PratoEntity praId;
    private PedidoEntity pedIdItem;
    private Long iteQuantidade;
}
