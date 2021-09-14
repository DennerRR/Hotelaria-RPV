package com.rp5.authentication.repository;

import com.rp5.authentication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String nomeUsuario);
    @Transactional
    void deleteByEmail(String nomeUsuario);
}
