package com.rp4.evolucaodb.interfaces;

import java.util.List;

import com.rp4.evolucaodb.model.Cliente;
import com.rp4.evolucaodb.model.Funcionario;
import com.rp4.evolucaodb.model.Usuario;

public interface IUsuarioService {

    public void salvarUsuario(Usuario usuario);

    public Funcionario getFuncionarioById(Long id);

    public Cliente getClienteById(Long id);

    public List<Usuario> pegarTodosUsuarios();

    public void excluirUsuario(Long id);

    public Cliente atualizarCliente(Cliente cliente);

    public Funcionario atualizarFuncionario(Funcionario funcionario);

}
