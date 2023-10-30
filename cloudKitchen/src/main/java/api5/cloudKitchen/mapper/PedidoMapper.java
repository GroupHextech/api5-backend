package api5.cloudKitchen.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.PedidoRequestDTO;
import api5.cloudKitchen.DTO.PedidoResponseDTO;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.entity.ReservaEntity;
import api5.cloudKitchen.repository.ReservaRepository;

@Component
public class PedidoMapper {

    @Autowired
    ReservaRepository reservaRepository;

    public PedidoEntity map(PedidoRequestDTO pedidoRequestDTO) throws Exception {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setPedHoraPedido(pedidoRequestDTO.getPedHoraPedido());
        pedidoEntity.setPedValorTotal(pedidoRequestDTO.getPedValorTotal());

        Optional<ReservaEntity> resOptional = reservaRepository.findById(pedidoRequestDTO.getResId());
        if (resOptional.isEmpty()) {
            throw new Exception("Reserva não existe");
        }
        pedidoEntity.setResId(resOptional.get());

        return pedidoEntity;
    }

    public PedidoResponseDTO map(PedidoEntity pedidoEntity) {
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();

        pedidoResponseDTO.setPedId(pedidoEntity.getPedId());
        pedidoResponseDTO.setPedHoraPedido(pedidoEntity.getPedHoraPedido());
        pedidoResponseDTO.setPedValorTotal(pedidoEntity.getPedValorTotal());
        pedidoResponseDTO.setReserva(pedidoEntity.getResId());

        return pedidoResponseDTO;
    }
}
