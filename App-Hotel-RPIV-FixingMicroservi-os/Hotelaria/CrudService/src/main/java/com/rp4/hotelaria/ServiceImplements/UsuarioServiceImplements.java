package com.rp4.hotelaria.ServiceImplements;

import java.util.List;

import com.rp4.hotelaria.ProducerMensagem.UsuarioProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rp4.hotelaria.interfaces.IUsuarioService;
import com.rp4.hotelaria.model.Cliente;
import com.rp4.hotelaria.model.Funcionario;
import com.rp4.hotelaria.model.Usuario;
import com.rp4.hotelaria.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplements implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioProducer usuarioProducer;

    @Autowired
    public UsuarioServiceImplements(UsuarioRepository usuarioR,UsuarioProducer usuarioProducer) {
        this.usuarioRepository = usuarioR;
        this.usuarioProducer = usuarioProducer;

    }

    @Override
    @Transactional
    public void salvarUsuario(Usuario usuario) {
       Usuario usuarioSalvo = usuarioRepository.save(usuario);
        usuarioProducer.producerMensagem(usuarioSalvo);
    }

    @Override
    public Funcionario getFuncionarioById(Long id) {
        return usuarioRepository.findFuncionarioById(id);
    }

    @Override
    public Cliente getClienteById(Long id) {
        return usuarioRepository.findClienteById(id);
    }

    @Override
    public List<Usuario> pegarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return usuarioRepository.save(cliente);
    }

    @Override
    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return usuarioRepository.save(funcionario);
    }

}
