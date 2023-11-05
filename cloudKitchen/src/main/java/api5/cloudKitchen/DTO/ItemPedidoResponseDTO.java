package api5.cloudKitchen.DTO;

import lombok.Data;

@Data
public class ItemPedidoResponseDTO {
    private PratoDTO prato;
    private Long iteQuantidade;
}
