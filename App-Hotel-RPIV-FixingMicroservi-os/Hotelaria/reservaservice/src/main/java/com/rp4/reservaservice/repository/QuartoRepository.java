package com.rp4.reservaservice.repository;

import com.rp4.reservaservice.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    Quarto findQuartoByIdQuarto(Long id);
}
