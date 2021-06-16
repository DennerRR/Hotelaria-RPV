package com.rp4.hotelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rp4.hotelaria.model.Cliente;
import com.rp4.hotelaria.model.Funcionario;
import com.rp4.hotelaria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Funcionario findFuncionarioById(Long id);

    Cliente findClienteById(Long id);
}
