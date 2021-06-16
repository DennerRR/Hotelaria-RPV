package com.rp4.consumoservice.repository;

import com.rp4.consumoservice.model.Consumo;
import com.rp4.consumoservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
    Consumo findConsumoById(Long id);
    List<Consumo> findAllConsumoByUsuario(Usuario usuario);
}
