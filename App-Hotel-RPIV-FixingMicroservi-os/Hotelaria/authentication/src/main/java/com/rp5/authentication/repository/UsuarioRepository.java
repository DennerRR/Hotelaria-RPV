package com.rp5.authentication.repository;

import com.rp5.authentication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String nomeUsuario);
    void deleteByEmail(String nomeUsuario);
}
