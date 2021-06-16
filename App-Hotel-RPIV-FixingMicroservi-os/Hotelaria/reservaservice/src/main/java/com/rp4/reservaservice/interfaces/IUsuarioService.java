package com.rp4.reservaservice.interfaces;

import com.rp4.reservaservice.model.Usuario;

public interface IUsuarioService {
    Usuario findUsuarioById(Long id);
}
