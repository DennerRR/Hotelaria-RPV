package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Long> {
    Servico findServicoById(Long id);
}
