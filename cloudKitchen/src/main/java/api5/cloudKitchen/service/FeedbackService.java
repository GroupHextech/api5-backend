package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.RestauranteRepository;

@Service
public class FeedbackService {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
}
