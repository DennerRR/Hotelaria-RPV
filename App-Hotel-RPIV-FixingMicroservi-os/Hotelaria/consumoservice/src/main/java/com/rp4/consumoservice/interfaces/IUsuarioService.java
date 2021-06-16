package com.rp4.consumoservice.interfaces;

import com.rp4.consumoservice.model.Usuario;

public interface IUsuarioService {
    Usuario findUsuarioById(Long id);
}
