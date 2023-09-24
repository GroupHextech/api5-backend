package api5.cloudKitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.RestauranteRepository;

@Service
public class FeedbackService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public FeedbackService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Double obterMediaDesempenhoRestaurante() {
        return restauranteRepository.consultarMediaDesempenhoRestaurante();
    }

    public List<Object[]> obterQuantidadeNotasRestaurante() {
        return restauranteRepository.consultarQuantidadeNotasRestaurante();
    }

}
