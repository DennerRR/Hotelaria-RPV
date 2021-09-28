package com.rp4.evolucaodb.repository;

import com.rp4.evolucaodb.model_new.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Long> {
    Servico findServicoById(Long id);
}
