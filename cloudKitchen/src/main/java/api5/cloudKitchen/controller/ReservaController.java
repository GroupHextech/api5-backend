package api5.cloudKitchen.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.DTO.ItemPedidoRequestDTO;
import api5.cloudKitchen.DTO.PedidoRequestDTO;
import api5.cloudKitchen.DTO.PedidoResponseDTO;
import api5.cloudKitchen.mapper.PedidoMapper;
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

    @Autowired
    private PedidoMapper pedidoMapper;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/prato")
    public List<Object[]> getPratos() {
        return reservaService.getPratos();
    }

    @GetMapping("/{tipoConsulta}")
    public List<Object[]> getReservaPorTipo(@PathVariable String tipoConsulta) {
        switch (tipoConsulta) {
            case "all":
                return reservaService.getAllReserva();
            case "livre":
                return reservaService.getReservaLivre();
            case "ocupada":
                return reservaService.getReservaOcupada();
            case "reservada":
                return reservaService.getReservaReservada();
            default:
                return Collections.emptyList();
        }
    }

    @PostMapping("/pedidos")
    public PedidoResponseDTO criarPedido(@RequestBody PedidoRequestDTO pedidoDTO) {
        try {
            return pedidoMapper.map(pedidoService.novoPedido(pedidoDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/atualizar/{pedId}")
    public PedidoResponseDTO atualizarPedido(
        @PathVariable Long pedId, @RequestBody PedidoRequestDTO pedidoRequestDTO
    ) {
        try {
            return pedidoMapper.map(pedidoService.atualizarPedido(pedidoRequestDTO, pedId));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/atualizarItens/{pedId}")
    public PedidoResponseDTO atualizarPedidoItem(
        @PathVariable Long pedId, @RequestBody List<ItemPedidoRequestDTO> itens
    ) {
        try {
            return pedidoMapper.map(pedidoService.atualizarItens(itens, pedId));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}