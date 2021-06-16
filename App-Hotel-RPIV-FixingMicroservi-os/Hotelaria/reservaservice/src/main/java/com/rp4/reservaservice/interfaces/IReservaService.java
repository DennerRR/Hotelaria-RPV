package com.rp4.reservaservice.interfaces;

import com.rp4.reservaservice.model.Reserva;
import com.rp4.reservaservice.model.Usuario;

import java.util.List;

public interface IReservaService {

    void saveReserva(Reserva reserva);

    public Reserva updateReserva(Reserva reserva);

    public Reserva findReservaById(Long id);

    public List<Reserva> findAllReservaByUsuario(Usuario usuario);
}
