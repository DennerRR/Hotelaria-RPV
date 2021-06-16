package com.rp4.reservaservice.ServiceImplements;

import com.rp4.reservaservice.interfaces.IReservaService;
import com.rp4.reservaservice.model.Reserva;
import com.rp4.reservaservice.model.Usuario;
import com.rp4.reservaservice.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImplements implements IReservaService {

    private ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImplements(ReservaRepository reservaR) {
        this.reservaRepository = reservaR;

    }

    @Override
    public void saveReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public Reserva updateReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva findReservaById(Long id) {
        return reservaRepository.findReservaById(id);
    }

    @Override
    public List<Reserva> findAllReservaByUsuario(Usuario usuario) {
        return reservaRepository.findAllByUsuario(usuario);
    }

}
