package com.rp4.evolucaodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rp4.evolucaodb.model_new.Cliente;
import com.rp4.evolucaodb.model_new.Funcionario;
import com.rp4.evolucaodb.model_new.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Funcionario findFuncionarioById(Long id);

    Cliente findClienteById(Long id);
}
