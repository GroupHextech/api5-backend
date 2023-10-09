package api5.cloudKitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.PedidoRepository;

@Service
public class FeedbackService {

    @Autowired
    private PedidoRepository restauranteRepository;

    public FeedbackService(PedidoRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Double obterMediaDesempenhoRestaurante() {
        return restauranteRepository.consultarMediaDesempenhoRestaurante();
    }

    public List<Object[]> obterQuantidadeNotasRestaurante() {
        return restauranteRepository.consultarQuantidadeNotasRestaurante();
    }

}
