package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.ServicoDTO;
import com.rp4.hotelaria.interfaces.IServicoService;
import com.rp4.hotelaria.model.Funcionario;
import com.rp4.hotelaria.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/servicos")
public class ServicoController {
    @Autowired
    private IServicoService servicoService;


    public ServicoController(IServicoService servicoService){
        this.servicoService = servicoService;
    }

    @RequestMapping(value = "/listarServicos", method = RequestMethod.GET)
    public ModelAndView getService(){
        ModelAndView mv = new ModelAndView("service");
        List<Servico> service = servicoService.pegarTodosServicos();
        mv.addObject("service", service);
        return mv;
    }

    @RequestMapping(value = "/salvarServico", method = RequestMethod.GET)
    public String form(){
        return "cadService";
    }

    @RequestMapping(value = "/salvarServico", method = RequestMethod.POST)
    public String form(Servico servico){
        servicoService.salvarServico(servico);
        return "redirect:/api/servicos/salvarServico";
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
        servico.setNomeServico(servicoDTO.getServico());
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
