package api5.cloudKitchen.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.ItemPedidoResponseDTO;
import api5.cloudKitchen.DTO.PedidoRequestDTO;
import api5.cloudKitchen.entity.ItemPedidoEntity;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.entity.PratoEntity;
import api5.cloudKitchen.entity.ReservaEntity;
import api5.cloudKitchen.repository.ReservaRepository;

@Component
public class ItemPedidoMapper {

    @Autowired
    ReservaRepository reservaRepository;

    public ItemPedidoEntity map(PedidoRequestDTO pedidoRequestDTO) throws Exception {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

        Optional<ReservaEntity> praOptional = reservaRepository.findById(pedidoRequestDTO.getPraId());
        if (praOptional.isEmpty()) {
            throw new Exception("Prato não existe");
        }
        itemPedidoEntity.setPraId(praOptional.get());

        return itemPedidoEntity;
    }
    
    public ItemPedidoResponseDTO map(ItemPedidoEntity itemPedidoEntity) {
        ItemPedidoResponseDTO itemPedidoResponseDTO = new ItemPedidoResponseDTO();

        itemPedidoResponseDTO.getPraId(itemPedidoEntity.getPraId());
        itemPedidoResponseDTO.getPedId(itemPedidoEntity.getPedId ());
        itemPedidoResponseDTO.getIteQuantidade(itemPedidoEntity.getIteQuantidade());

        return itemPedidoResponseDTO;
    }
}
