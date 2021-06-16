package com.rp4.servicos.interfaces;

import com.rp4.servicos.model.Usuario;

public interface IUsuarioService {
    Usuario findUsuarioById(Long id);
}