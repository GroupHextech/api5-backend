package api5.cloudKitchen.DTO;

import lombok.Data;

@Data
public class ItemPedidoRequestDTO {
    private Long praId;
    private Long pedId;
    private Long iteQuantidade;
}