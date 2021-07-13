package com.rp4.turismo.interfaces;

import com.rp4.turismo.model.Usuario;

public interface IUsuarioService {
    Usuario findUsuarioById(Long id);
}
