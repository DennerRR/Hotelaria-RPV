package com.rp4.hotelaria.controller;


import com.rp4.hotelaria.dto.CidadeDTO;
import com.rp4.hotelaria.interfaces.ICidadeService;
import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cidades")

@Api(value = "API Rest Cidades")

//Liberar todos domínios para acessar essa API
@CrossOrigin(origins = "*")
public class CidadeController {
    private ICidadeService cidadeService;

    public CidadeController(ICidadeService cidadeService) {
        this.cidadeService = cidadeService;

    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Salvar uma cidade")
    public void salvarCidade(@RequestBody CidadeDTO cidadeDTO){
         Cidade cidade = new Cidade();
        cidade.setId(cidadeDTO.getId());
        cidade.setNome(cidadeDTO.getNome());
        cidade.setDdd(cidadeDTO.getDdd());
        cidadeService.saveCidade(cidade);

    }
    @PutMapping("/cidade/atualizar")
    @ApiOperation(value = "Atualizar cidade")
    public Cidade updateCidade(@RequestBody Cidade cidade){
        return cidadeService.updateCidade(cidade);
    }

    @GetMapping("/cidade/{id}")
    @ApiOperation(value = "Retornar uma cidade pelo id")
    public ResponseEntity<?> pegarCidadePeloId(@PathVariable("id") Long id){
        Cidade cidade = cidadeService.findCidadeById(id);
        return new ResponseEntity<>(cidade, HttpStatus.OK);
    }

    @GetMapping("/todas/cidades")
    @ApiOperation(value = "Retorna uma lista de Cidades")
    public List<Cidade> pegarTodasCidades(){
        List<Cidade> cidades = cidadeService.findAllCidade();
        return cidades;
    }

    @DeleteMapping("/cidade/excluir/{id}")
    @ApiOperation(value = "Deletar cidade pelo id")
    public void deletarCidade(@PathVariable("id")Long id){
        cidadeService.deleteCidade(id);

    }

}
