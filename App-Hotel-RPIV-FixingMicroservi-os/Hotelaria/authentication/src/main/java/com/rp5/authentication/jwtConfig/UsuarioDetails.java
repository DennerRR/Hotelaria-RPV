package com.rp5.authentication.jwtConfig;

import com.rp5.authentication.model.Usuario;
import com.rp5.authentication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetails implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário '" + email + "' não encontrado, tente novamente.");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(usuario.getSenha())
                .authorities(usuario.getCargos())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
