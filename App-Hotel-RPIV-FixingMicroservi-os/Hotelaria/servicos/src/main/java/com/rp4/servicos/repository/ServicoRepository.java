package com.rp4.servicos.repository;

import com.rp4.servicos.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    Servico findServicoById(Long id);
}
