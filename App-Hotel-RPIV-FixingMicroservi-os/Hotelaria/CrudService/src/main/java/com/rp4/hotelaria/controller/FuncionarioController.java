package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.UsuarioDTO;
import com.rp4.hotelaria.interfaces.IUsuarioService;
import com.rp4.hotelaria.model.Funcionario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Funcionarios")

@Api(value = "API Rest Funcionarios")

//Liberar todos domínios para acessar essa API
@CrossOrigin(origins = "*")

public class FuncionarioController {


    private IUsuarioService funcionarioService;


    public FuncionarioController(IUsuarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
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
        funcionarioService.salvarUsuario(funcionario);
    }

    @GetMapping("funcionario/pegar/{id}")
    @ApiOperation(value = "Retorna um funcionário")
    public ResponseEntity<?> pegarFuncionarioPeloId(@PathVariable("id") Long id) {
        com.rp4.hotelaria.model.Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PutMapping("/funcionario/atualizar")
    @ApiOperation(value = "Atualiza um funcionário")
    public com.rp4.hotelaria.model.Funcionario atualizarFuncionario(@RequestBody com.rp4.hotelaria.model.Funcionario func) {
        com.rp4.hotelaria.model.Funcionario funcionario = funcionarioService.atualizarFuncionario(func);
        return funcionario;
    }
}
