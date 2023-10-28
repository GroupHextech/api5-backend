package api5.cloudKitchen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.DTO.PedidoDTO;
import api5.cloudKitchen.entity.ItemPedidoEntity;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.repository.ItemPedidoRepository;
import api5.cloudKitchen.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public PedidoEntity novoPedido(PedidoDTO pedidoDTO) {

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setPedId(pedidoDTO.getPedId());
        pedidoEntity.setPedHoraPedido(pedidoDTO.getPedHoraPedido());
        pedidoEntity.setPedValorTotal(pedidoDTO.getPedValorTotal());
        pedidoEntity.setResId(pedidoDTO.getResId());

        pedidoEntity = pedidoRepository.save(pedidoEntity);

        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
        itemPedidoEntity.setPraId(pedidoDTO.getPraId());
        itemPedidoEntity.setPedId(pedidoDTO.getPedIdItem());
        itemPedidoEntity.setIteQuantidade(pedidoDTO.getIteQuantidade());

        itemPedidoRepository.save(itemPedidoEntity);

        return pedidoEntity;

    }

    public PedidoEntity atualizarPedido(Long pedId, PedidoDTO pedidoDTO) {
        Optional<PedidoEntity> pedidoOptional = pedidoRepository.findById(pedId);
        if (pedidoOptional.isPresent()) {
            PedidoEntity pedidoExistente = pedidoOptional.get();

            pedidoExistente.setPedValorTotal(pedidoDTO.getPedValorTotal());

            return pedidoRepository.save(pedidoExistente);
        } else {
            return null;
        }
    }

}
