package com.rp4.hotelaria.interfaces;

import java.util.List;

import com.rp4.hotelaria.model.Cliente;
import com.rp4.hotelaria.model.Funcionario;
import com.rp4.hotelaria.model.Usuario;

public interface IUsuarioService {

    public void salvarUsuario(Usuario usuario);

    public Funcionario getFuncionarioById(Long id);

    public Cliente getClienteById(Long id);

    public List<Usuario> pegarTodosUsuarios();

    public void excluirUsuario(Long id);

    public Cliente atualizarCliente(Cliente cliente);

    public Funcionario atualizarFuncionario(Funcionario funcionario);

}
