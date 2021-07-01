package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.UsuarioDTO;
import com.rp4.hotelaria.interfaces.IUsuarioService;
import com.rp4.hotelaria.model.Cliente;
import com.rp4.hotelaria.model.Funcionario;
import com.rp4.hotelaria.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")

@Api(value = "API Rest Usuários")

//Liberar todos domínios para acessar essa API
@CrossOrigin(origins = "*")

public class UsuarioController {

    private IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioServ) {
        this.usuarioService = usuarioServ;

    }

    @GetMapping("/todos")
    @ApiOperation(value = "Retorna uma lista de Usuários")
    public List<Usuario> pegarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.pegarTodosUsuarios();
        return usuarios;
    }

    @DeleteMapping("/excluir/{id}")
    @ApiOperation(value = "Exclui um Usuário")
    public void deleteUser(@PathVariable("id") Long id) {
        usuarioService.excluirUsuario(id);
    }
}