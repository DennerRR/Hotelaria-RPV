package com.rp4.hotelaria.controller;


import com.rp4.hotelaria.dto.CidadeDTO;
import com.rp4.hotelaria.interfaces.ICidadeService;
import com.rp4.hotelaria.interfaces.IHotelService;
import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Produto;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller

//Liberar todos domínios para acessar essa API
//@CrossOrigin(origins = "*")
public class CidadeController {

    @Autowired
    private ICidadeService cidadeService;

    @Autowired
    private IHotelService hotelService;

    @RequestMapping(value = "salvarCidade", method = RequestMethod.GET)
    public String form() {
    return "cidade/formCidade";
    }

    @RequestMapping(value = "salvarCidade", method = RequestMethod.POST)
    public String form(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/salvarCidade";
        }
        cidadeService.saveCidade(cidade);
        attributes.addFlashAttribute("mensagem", "Cidade cadastrada com sucesso!");
        return "redirect:/verCidades";
    }

    @RequestMapping(value = "/verCidades")
    public ModelAndView listaCidades(){
        ModelAndView mv = new ModelAndView("cidade/cidade");
        Iterable<Cidade> cidades = cidadeService.findAllCidade();
        mv.addObject("cidade",cidades);
        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesCidades(@PathVariable("id") long id){
        Cidade cidade = cidadeService.findCidadeById(id);
        ModelAndView mv = new ModelAndView("cidade/detalhesCidade");
        mv.addObject("cidade",cidade);

        Iterable<Hotel> hoteis = hotelService.findAllHotelByCidade(cidade);
        mv.addObject("hoteis", hoteis);
        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String detalhesCidadesPost(@PathVariable("id") long id, @Valid Hotel hotel, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/{id}";
        }
        Cidade cidade = cidadeService.findCidadeById(id);
        hotel.setCidade(cidade);
        hotelService.salvarHotel(hotel);
        attributes.addFlashAttribute("mensagem", "Hotel cadastrado com sucesso!");
        return "redirect:/{id}";
    }

    @RequestMapping("/deletarCidade")
    public String deletarCidade(long id){
        Cidade cidade = cidadeService.findCidadeById(id);
        cidadeService.deleteCidade(id);
        return "redirect:/verCidades";
    }

    @RequestMapping("/deletarHotel")
    public String excluirHotel(long id){
        Hotel hotel = hotelService.getHotelById(id);
        hotelService.excluirHotel(id);
        Cidade cidade = hotel.getCidade();
        long idLong = hotel.getIdHotel();
        String idd = "" + idLong;
        return "redirect:/" + idd;
    }

    /*@GetMapping("/alterarCidade{id}")
    public String alterarCidade(@PathVariable("id") long id, Cidade cidade, Model model){
            model.add("cidade", cidade);
            cidadeService.findCidadeById(id);
            cidadeService.saveCidade(cidade);
            return "redirect:/verCidades";
        }*/

    }
/*
    @RequestMapping("/deletarHotel")
    public void deleteHotel(@PathVariable("id") Long id) {
        hotelService.excluirHotel(id);
    }

  /



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

   /* @DeleteMapping("/cidade/excluir/{id}")
    @ApiOperation(value = "Deletar cidade pelo id")
    public void deletarCidade(@PathVariable("id")Long id){
        cidadeService.deleteCidade(id);

    }*/


