package com.rp5.authentication.controller;

import javax.servlet.http.HttpServletRequest;

import com.rp5.authentication.DTO.TodoUsuarioDTO;
import com.rp5.authentication.DTO.UsuarioDTO;
import com.rp5.authentication.Service.UsuarioService;
import com.rp5.authentication.jwtConfig.HttpExc;
import com.rp5.authentication.model.Usuario;
import com.rp5.authentication.producer.SignupProducer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private SignupProducer signupSender;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signin")
    @ApiOperation(value = "${UsuarioController.signin}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algo deu errado"),
            @ApiResponse(code = 422, message = "Nome/senha invalidos")
    })
    public ResponseEntity<String> login(
            @ApiParam("Email") @RequestParam String email,
            @ApiParam("Senha") @RequestParam String senha) {
        try {
            String token = userService.signin(email, senha);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (HttpExc e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
    }

    @PostMapping("/signup")
    @ApiOperation(value = "${UsuarioController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algo deu errado"),
            @ApiResponse(code = 422, message = "Email em uso"),
    })
    public ResponseEntity<String> signup(@ApiParam("Usuario cadastrando") @RequestBody TodoUsuarioDTO user) {
        // cria um usuario basico para salvar aqui no microservico
        // (usuario, email e senha)
        // o usuario real vai para a fila do rabbit para ser consumido pelo CRUD
        Usuario basicUser = new Usuario();
        basicUser.setNomeUsuario(user.getNomeUsuario());
        basicUser.setEmail(user.getEmail());
        basicUser.setSenha(user.getSenha());
        basicUser.setCargos(user.getCargos());
        try {
            String token = userService.signup(basicUser);
            signupSender.sendMessage(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (HttpExc e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
    }

}