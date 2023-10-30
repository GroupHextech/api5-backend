package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.DTO.PedidoDTO;
import api5.cloudKitchen.entity.PedidoEntity;
import api5.cloudKitchen.service.PedidoService;
import api5.cloudKitchen.service.ReservaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private final ReservaService reservaService;

    @Autowired
    private PedidoService pedidoService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/prato")
    public List<Object[]> getPratos() {
        return reservaService.getPratos();
    }

    @GetMapping("/reservado")
    public List<Object[]> getReservaReservado() {
        return reservaService.getReservaReservado();
    }

    @PostMapping("/pedidos")
    public PedidoEntity criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.novoPedido(pedidoDTO);
    }

}
