package com.rp4.reservaservice.repository;

import com.rp4.reservaservice.model.Reserva;
import com.rp4.reservaservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findReservaById(Long id);
    List<Reserva> findAllByUsuario(Usuario usuario);
}
