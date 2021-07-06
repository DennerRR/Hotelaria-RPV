package com.rp4.turismo.interfaces;

import com.rp4.turismo.model.Reserva;
import com.rp4.turismo.model.Usuario;

import java.util.List;

public interface IReservaService {

    void saveReserva(Reserva reserva);

    public Reserva updateReserva(Reserva reserva);

    public Reserva findReservaById(Long id);

    public List<Reserva> findAllReservaByUsuario(Usuario usuario);

}
