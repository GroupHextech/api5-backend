package api5.cloudKitchen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.DTO.PedidoRequestDTO;
import api5.cloudKitchen.DTO.PedidoResponseDTO;
import api5.cloudKitchen.entity.ItemPedidoEntity;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.mapper.PedidoMapper;
import api5.cloudKitchen.repository.ItemPedidoRepository;
import api5.cloudKitchen.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    public PedidoEntity novoPedido(PedidoRequestDTO pedidoRequestDTO) throws Exception {

        PedidoEntity pedidoEntity = pedidoRepository.save(pedidoMapper.map(pedidoRequestDTO));

        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

        return pedidoEntity;

    }

    public PedidoEntity atualizarPedido(Long pedId, PedidoResponseDTO pedidoRequestDTO) {
        Optional<PedidoEntity> pedidoOptional = pedidoRepository.findById(pedId);
        if (pedidoOptional.isPresent()) {
            PedidoEntity pedidoExistente = pedidoOptional.get();

            pedidoExistente.setPedValorTotal(pedidoRequestDTO.getPedValorTotal());

            return pedidoRepository.save(pedidoExistente);
        } else {
            return null;
        }
    }

}