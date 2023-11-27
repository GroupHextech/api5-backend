package api5.cloudKitchen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.DTO.ItemPedidoRequestDTO;
import api5.cloudKitchen.DTO.PedidoRequestDTO;
import api5.cloudKitchen.entity.ItemPedidoEntity;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.mapper.ItemPedidoMapper;
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

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;

    public PedidoEntity novoPedido(PedidoRequestDTO pedidoRequestDTO) throws Exception {

        PedidoEntity pedidoEntity = pedidoRepository.save(pedidoMapper.map(pedidoRequestDTO));
        List<ItemPedidoEntity> itens = new ArrayList<ItemPedidoEntity>();
        for(ItemPedidoRequestDTO item: pedidoRequestDTO.getItens()){
            item.setPedId(pedidoEntity.getPedId());
            itens.add(itemPedidoRepository.save(itemPedidoMapper.map(item)));
        }
        pedidoEntity.setItens(itens);
        return pedidoEntity;

    }

    public PedidoEntity atualizarPedido(PedidoRequestDTO pedidoRequestDTO, Long pedId) throws Exception {

        Optional<PedidoEntity> pedidoOptional = pedidoRepository.findById(pedId);

        if (pedidoOptional.isPresent()) {
            PedidoEntity pedidoExistente = pedidoOptional.get();

            PedidoEntity pedidoUpdate = pedidoMapper.map(pedidoRequestDTO);

            pedidoExistente.setPedHoraEntregue(pedidoUpdate.getPedHoraEntregue());
            pedidoExistente.setPedValorTotal(pedidoUpdate.getPedValorTotal());

            return pedidoRepository.save(pedidoExistente);
        } else {
            throw new Exception("pedido não existe");
        }

    }

    public PedidoEntity atualizarItens(List<ItemPedidoRequestDTO> itens, Long pedId) throws Exception {

        Optional<PedidoEntity> pedidoOptional = pedidoRepository.findById(pedId);

        if (pedidoOptional.isPresent()) {
            PedidoEntity pedidoExistente = pedidoOptional.get();

            itens.forEach(item-> {
                try {
                    if(pedidoExistente.getItens().contains(itemPedidoMapper.map(item))) {
                        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

                        itemPedidoEntity = itemPedidoMapper.map(item);

                        List<ItemPedidoEntity> itemUpdate = new ArrayList<ItemPedidoEntity>();
                        itemUpdate.add(itemPedidoEntity);

                        pedidoExistente.setItens(itemUpdate);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return pedidoRepository.save(pedidoExistente);
        } else {
            throw new Exception("aconteceu algum erro");
        }

    }

}
