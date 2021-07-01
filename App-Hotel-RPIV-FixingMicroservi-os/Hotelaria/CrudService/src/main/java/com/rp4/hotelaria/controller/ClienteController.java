package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.UsuarioDTO;
import com.rp4.hotelaria.interfaces.IUsuarioService;
import com.rp4.hotelaria.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Clientes")

@Api(value = "API Rest Clientes")

//Liberar todos domínios para acessar essa API
@CrossOrigin(origins = "*")

public class ClienteController {
    private IUsuarioService clienteService;

    public ClienteController(IUsuarioService clienteService) {
        this.clienteService = clienteService;
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
        clienteService.salvarUsuario(cliente);
    }

     @GetMapping("cliente/pegar/{id}")
    @ApiOperation(value = "Retorna um Cliente")
    public Cliente pegarClientePeloID(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return cliente;
    }

     @PutMapping("/cliente/atualizar")
    @ApiOperation(value = "Atualiza um cliente")
    public Cliente atualizarCliente(@RequestBody Cliente cli) {
        Cliente cliente = clienteService.atualizarCliente(cli);
        return cliente;
    }

}
