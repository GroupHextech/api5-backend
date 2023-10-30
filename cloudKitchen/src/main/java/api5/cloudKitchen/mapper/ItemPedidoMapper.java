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
import api5.cloudKitchen.repository.PedidoRepository;
import api5.cloudKitchen.repository.PratoRepository;
import api5.cloudKitchen.repository.ReservaRepository;

@Component
public class ItemPedidoMapper {

    @Autowired
    PratoRepository pratoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public ItemPedidoEntity map(PedidoRequestDTO pedidoRequestDTO) throws Exception {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

        Optional<PratoEntity> praOptional = pratoRepository.findById(pedidoRequestDTO.getPraId());
        if (praOptional.isEmpty()) {
            throw new Exception("Prato não existe");
        }
        itemPedidoEntity.setPraId(praOptional.get());

        Optional<PedidoEntity> pedOptional = pedidoRepository.findById(pedidoRequestDTO.getPedIdItem());
        if (pedOptional.isEmpty()) {
            throw new Exception("Pedido não existe");
        }
        itemPedidoEntity.setPedId(pedOptional.get());

        itemPedidoEntity.setIteQuantidade(pedidoRequestDTO.getIteQuantidade());

        return itemPedidoEntity;
    }

    public ItemPedidoResponseDTO map(ItemPedidoEntity itemPedidoEntity) {
        ItemPedidoResponseDTO itemPedidoResponseDTO = new ItemPedidoResponseDTO();

        itemPedidoResponseDTO.setPraId(itemPedidoEntity.getPraId());
        itemPedidoResponseDTO.setPedIdItem(itemPedidoEntity.getPedId ());
        itemPedidoResponseDTO.setIteQuantidade(itemPedidoEntity.getIteQuantidade());

        return itemPedidoResponseDTO;
    }
}
