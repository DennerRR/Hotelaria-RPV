package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Quarto findQuartoByIdQuarto(Long id);

}
