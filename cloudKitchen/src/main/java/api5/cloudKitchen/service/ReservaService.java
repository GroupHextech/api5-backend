package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api5.cloudKitchen.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Object[]> getPratos() {
        return reservaRepository.getPratos();
    }

    public List<Object[]> getAllReserva() {
        return reservaRepository.getAllReserva();
    }

    public List<Object[]> getReservaLivre() {
        return reservaRepository.getReservaLivre();
    }

    public List<Object[]> getReservaOcupada() {
        return reservaRepository.getReservaOcupada();
    }

    public List<Object[]> getReservaReservada() {
        return reservaRepository.getReservaReservada();
    }

}
