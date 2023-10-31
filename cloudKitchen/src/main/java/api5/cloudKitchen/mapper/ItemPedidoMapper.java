package api5.cloudKitchen.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.ItemPedidoRequestDTO;
import api5.cloudKitchen.DTO.ItemPedidoResponseDTO;
import api5.cloudKitchen.DTO.PratoDTO;
import api5.cloudKitchen.entity.ItemPedidoEntity;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.entity.PratoEntity;
import api5.cloudKitchen.repository.PedidoRepository;
import api5.cloudKitchen.repository.PratoRepository;


@Component
public class ItemPedidoMapper {

    @Autowired
    PratoRepository pratoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PratoMapper pratoMapper;

    public ItemPedidoEntity map(ItemPedidoRequestDTO itemPedidoRequestDTO) throws Exception {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

        Optional<PratoEntity> prato = pratoRepository.findById(itemPedidoRequestDTO.getPraId());

        if(prato.isEmpty()){
            throw new Exception("Prato não existe");
        }

        Optional<PedidoEntity> pedido = pedidoRepository.findById(itemPedidoRequestDTO.getPedId());

        if(pedido.isEmpty()){
            throw new Exception("Prato não existe");
        }

        itemPedidoEntity.setPraId(prato.get());
        itemPedidoEntity.setPedId(pedido.get());
        itemPedidoEntity.setIteQuantidade(itemPedidoRequestDTO.getIteQuantidade());

        return itemPedidoEntity;
    }

    public ItemPedidoResponseDTO map(ItemPedidoEntity itemPedidoEntity) {
        ItemPedidoResponseDTO itemPedidoResponseDTO = new ItemPedidoResponseDTO();

        PratoDTO prato = pratoMapper.map(itemPedidoEntity.getPraId());

        itemPedidoResponseDTO.setPrato(prato);
        itemPedidoResponseDTO.setIteQuantidade(itemPedidoEntity.getIteQuantidade());

        return itemPedidoResponseDTO;
    }
}
