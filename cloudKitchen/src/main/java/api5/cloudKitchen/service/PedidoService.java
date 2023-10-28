package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.DTO.PedidoDTO;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoEntity novoPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setPedHoraPedido(pedidoDTO.getPedHoraPedido());
        pedidoEntity.setPedValorTotal(pedidoDTO.getPedValorTotal());

        return pedidoRepository.save(pedidoEntity);
    }

}
