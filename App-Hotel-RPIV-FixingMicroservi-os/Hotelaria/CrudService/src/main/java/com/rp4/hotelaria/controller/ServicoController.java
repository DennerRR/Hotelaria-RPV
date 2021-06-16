package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.ServicoDTO;
import com.rp4.hotelaria.interfaces.IServicoService;
import com.rp4.hotelaria.model.Servico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serviços")
public class ServicoController {
    private IServicoService servicoService;

    public ServicoController(IServicoService servicoService){
        this.servicoService = servicoService;
    }
    @GetMapping("/todos")
    public List<Servico> pegarTodosServicos(){
        List<Servico> servicos = servicoService.pegarTodosServicos();
        return servicos;
    }
    @PostMapping("/serviço/salvar")
    public void salvarServico(@RequestBody ServicoDTO servicoDTO){
        Servico servico= new Servico();
        servico.setId(servicoDTO.getId());
        servico.setServico(servicoDTO.getServico());
        servico.setValor(servicoDTO.getValor());
        servicoService.salvarServico(servico);

    }
    @GetMapping("serviços/pegar/{id}")
    public Servico pegarServicoPeloID(@PathVariable("id")Long id){
        return servicoService.getServicoById(id);
    }
    @PutMapping("/serviços/atualizar")
    public Servico atualizarServico(@RequestBody Servico servico){
        Servico serv = servicoService.atualizarServico(servico);
        return serv;
    }
    @DeleteMapping("/serviços/excluir/{id}")
    public void deletarServico(@PathVariable("id")Long id){
        servicoService.excluirServico(id);
    }
}
