package com.rp4.turismo.ServiceImplements;


import com.rp4.turismo.interfaces.IUsuarioService;
import com.rp4.turismo.model.Usuario;
import com.rp4.turismo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioServiceImplements implements IUsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImplements(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findUsuarioById(id);
    }
}

