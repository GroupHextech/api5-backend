package api5.cloudKitchen.DTO;

import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.entity.PratoEntity;
import lombok.Data;

@Data
public class ItemPedidoResponseDTO {
    private PratoEntity praId;
    private PedidoEntity pedIdItem;
    private Long iteQuantidade;
}
