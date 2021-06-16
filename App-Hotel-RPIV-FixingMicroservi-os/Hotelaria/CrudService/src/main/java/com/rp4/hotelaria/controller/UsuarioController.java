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


    @PostMapping("/funcionario/salvar")
    @ApiOperation(value = "Salva um Funcionário")
    public void salvarFuncionario(@RequestBody UsuarioDTO usuarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(usuarioDTO.getId());
        funcionario.setEmail(usuarioDTO.getEmail());
        funcionario.setNome(usuarioDTO.getNome());
        
        funcionario.setCpf(usuarioDTO.getCpf());
        funcionario.setTelefone(usuarioDTO.getTelefone());
        funcionario.setSenha(usuarioDTO.getSenha());
        usuarioService.salvarUsuario(funcionario);
    }

    @PostMapping("/cliente/salvar")
    @ApiOperation(value = "Salva um Cliente")
    public void salvarCliente(@RequestBody UsuarioDTO usuarioDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(usuarioDTO.getId());
        cliente.setNome(usuarioDTO.getNome());
        cliente.setEmail(usuarioDTO.getEmail());
        cliente.setSenha(usuarioDTO.getSenha());
        cliente.setEndereco(usuarioDTO.getEndereco());
        cliente.setCpf(usuarioDTO.getCpf());
        cliente.setTelefone(usuarioDTO.getTelefone());
        usuarioService.salvarUsuario(cliente);
    }

    @GetMapping("funcionario/pegar/{id}")
    @ApiOperation(value = "Retorna um funcionário")
    public ResponseEntity<?> pegarFuncionarioPeloId(@PathVariable("id") Long id) {
        Funcionario funcionario = usuarioService.getFuncionarioById(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @GetMapping("cliente/pegar/{id}")
    @ApiOperation(value = "Retorna um Cliente")
    public Cliente pegarClientePeloID(@PathVariable("id") Long id) {
        Cliente cliente = usuarioService.getClienteById(id);
        return cliente;
    }

    @PutMapping("/funcionario/atualizar")
    @ApiOperation(value = "Atualiza um funcionário")
    public Funcionario atualizarFuncionario(@RequestBody Funcionario func) {
        Funcionario funcionario = usuarioService.atualizarFuncionario(func);
        return funcionario;
    }

    @PutMapping("/cliente/atualizar")
    @ApiOperation(value = "Atualiza um cliente")
    public Cliente atualizarCliente(@RequestBody Cliente cli) {
        Cliente cliente = usuarioService.atualizarCliente(cli);
        return cliente;
    }

    @DeleteMapping("/excluir/{id}")
    @ApiOperation(value = "Exclui um Usuário")
    public void deleteUser(@PathVariable("id") Long id) {
        usuarioService.excluirUsuario(id);
    }
}