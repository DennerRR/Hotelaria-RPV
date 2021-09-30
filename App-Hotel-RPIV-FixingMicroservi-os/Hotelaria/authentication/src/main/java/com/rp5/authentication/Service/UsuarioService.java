package com.rp5.authentication.Service;

import com.rp5.authentication.jwtConfig.Token;
import com.rp5.authentication.model.Usuario;
import com.rp5.authentication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import com.rp5.authentication.jwtConfig.HttpExc;




@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Token jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return jwtTokenProvider.criarToken(email, userRepository.findByEmail(email).getCargos());
        } catch(AuthenticationException e) {
            throw new HttpExc("senha ou email invalido", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(Usuario user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            user.setSenha(passwordEncoder.encode(user.getSenha()));
            userRepository.save(user);
            return jwtTokenProvider.criarToken(user.getEmail(), user.getCargos());
        } else {
            throw new HttpExc("Email ja cadastrado.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByEmail(username);
    }

    public Usuario search(String username) {
        Usuario user = userRepository.findByEmail(username);
        if(user == null) {
            throw new HttpExc("O usuario não existe.", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public Usuario whoami(HttpServletRequest req) {
        return userRepository.findByEmail(jwtTokenProvider.getNomeUsuario(jwtTokenProvider.resolverToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.criarToken(username, userRepository.findByEmail(username).getCargos());
    }

}