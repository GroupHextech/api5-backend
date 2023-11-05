package api5.cloudKitchen.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.ItemPedidoResponseDTO;
import api5.cloudKitchen.DTO.PedidoRequestDTO;
import api5.cloudKitchen.DTO.PedidoResponseDTO;
import api5.cloudKitchen.entity.ItemPedidoEntity;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.entity.ReservaEntity;
import api5.cloudKitchen.repository.ReservaRepository;

@Component
public class PedidoMapper {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ItemPedidoMapper itemPedidoMapper;

    public PedidoEntity map(PedidoRequestDTO pedidoRequestDTO) throws Exception {

        PedidoEntity pedidoEntity = new PedidoEntity();

        pedidoEntity.setPedHoraPedido(pedidoRequestDTO.getPedHoraPedido());
        pedidoEntity.setPedValorTotal(pedidoRequestDTO.getPedValorTotal());

        Optional<ReservaEntity> resOptional = reservaRepository.findById(pedidoRequestDTO.getResId());
        if (resOptional.isEmpty()) {
            throw new Exception("Reserva não existe");
        }

        List<ItemPedidoEntity> itens = new ArrayList<ItemPedidoEntity>();

        pedidoEntity.setResId(resOptional.get());
        pedidoEntity.setItens(itens);

        return pedidoEntity;

    }

    public PedidoResponseDTO map(PedidoEntity pedidoEntity) {

        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();

        pedidoResponseDTO.setPedId(pedidoEntity.getPedId());
        pedidoResponseDTO.setPedHoraPedido(pedidoEntity.getPedHoraPedido());
        pedidoResponseDTO.setPedHoraEntregue(pedidoEntity.getPedHoraEntregue());
        pedidoResponseDTO.setPedValorTotal(pedidoEntity.getPedValorTotal());
        pedidoResponseDTO.setPedAvaliacao(pedidoEntity.getPedAvaliacao());
        pedidoResponseDTO.setReserva(pedidoEntity.getResId());

        List<ItemPedidoResponseDTO> itens = new ArrayList<ItemPedidoResponseDTO>();
        pedidoEntity.getItens().forEach(item->{
            itens.add(itemPedidoMapper.map(item));
        });

        pedidoResponseDTO.setItens(itens);
        return pedidoResponseDTO;

    }
}
