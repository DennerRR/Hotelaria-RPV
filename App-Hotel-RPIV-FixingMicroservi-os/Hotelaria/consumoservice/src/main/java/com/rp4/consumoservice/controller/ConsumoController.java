package com.rp4.consumoservice.controller;

import com.rp4.consumoservice.dto.ConsumoDTO;
import com.rp4.consumoservice.interfaces.IConsumoService;
import com.rp4.consumoservice.interfaces.IProdutoService;
import com.rp4.consumoservice.interfaces.IUsuarioService;
import com.rp4.consumoservice.model.Consumo;
import com.rp4.consumoservice.model.Produto;
import com.rp4.consumoservice.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Consumos")
@CrossOrigin(origins = "*")
public class ConsumoController {
    private IConsumoService consumoService;
    private IUsuarioService usuarioService;
    private IProdutoService produtoService;

    public ConsumoController(IConsumoService consumoService, IUsuarioService usuarioService, IProdutoService produtoService) {
        this.consumoService = consumoService;
        this.usuarioService = usuarioService;
        this.produtoService = produtoService;
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Cadastra um consumo")
    public void salvarConsumo(@RequestBody ConsumoDTO consumoDTO){
        Consumo consumo = new Consumo();
        Produto produto = produtoService.findProdutoById(consumoDTO.getIdProduto());
        Usuario usuario = usuarioService.findUsuarioById(consumoDTO.getIdUsuario());

        consumo.setId(consumoDTO.getId());
        consumo.setData(consumoDTO.getData());
        consumo.setUsuario(usuario);
        consumo.setProduto(produto);
        consumo.setValorConsumo(produto.getValor());
        consumoService.saveConsumo(consumo);
    }
//    @PutMapping("/consumo/atualizar")
//    @ApiOperation(value = "Atualizar uma consumo")
//    public ResponseEntity<?> updateConsumo(@RequestBody Consumo consumo) {
//        Consumo atualizarConsumo = consumoService.updateConsumo(consumo);
//        return new ResponseEntity<>(atualizarConsumo, HttpStatus.OK);
//    }
    @GetMapping("/consumo/{id}")
    public ResponseEntity<?> getConsumoById(@PathVariable("id") Long id) {
        Consumo consumo = consumoService.findConsumoById(id);
        return new ResponseEntity<>(consumo, HttpStatus.OK);
    }
    @DeleteMapping("/consumo/excluir/{id}")
    public void deleteConsumo(@PathVariable("id")Long id){consumoService.deleteConsumo(id);}

    @GetMapping("/usuario/encontrar/{id}")
    public ResponseEntity<?> getConsumoByUsuarioId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        List<Consumo> reservas = consumoService.findAllConsumosByUsuario(usuario);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }
}
