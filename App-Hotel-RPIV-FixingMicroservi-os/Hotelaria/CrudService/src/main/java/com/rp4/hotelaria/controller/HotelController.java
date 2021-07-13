package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.HotelDTO;
import com.rp4.hotelaria.interfaces.ICidadeService;
import com.rp4.hotelaria.interfaces.IHotelService;
import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteis")

public class HotelController {
    private IHotelService hotelService;
    private ICidadeService cidadeService;


    public HotelController(IHotelService hotelService, ICidadeService cidadeService) {
        this.hotelService = hotelService;
        this.cidadeService = cidadeService;
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Salvar hotel")
    public void saveHotel(@RequestBody HotelDTO hotelDTO) {
        Cidade cidade = cidadeService.findCidadeById(hotelDTO.getIdCidade());
        Hotel hotel = new Hotel();
        hotel.setCidade(cidade);
        hotel.setDescricao(hotelDTO.getDescricao());
        hotel.setEndereco(hotelDTO.getEndereco());
        hotel.setIdHotel(hotelDTO.getIdHotel());
        hotel.setCodEndereco(hotelDTO.getCodEndereco());
        hotelService.salvarHotel(hotel);
    }


    @GetMapping("/hotel/{id}")
    @ApiOperation(value = "Retornar hotel")
    public ResponseEntity<?> pegarHotelPeloId(@PathVariable("id") Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PutMapping("/hotel/atualizar")
    @ApiOperation(value = "Atualizar Hotel")
    public Hotel atualizarHotel(@RequestBody Hotel hotel) {
        return hotelService.atualizarHotel(hotel);
    }

    /*@DeleteMapping("/hotel/excluir/{id}")
    @ApiOperation(value = "Deletar hotel")
    public void deleteHotel(@PathVariable("id") Long id) {
        hotelService.excluirHotel(id);
    }*/

    @RequestMapping("/deletarHotel")
    public String excluirHotel(long id) {
        Hotel hotel = hotelService.getHotelById(id);
        hotelService.excluirHotel(id);
        Cidade cidade = hotel.getCidade();
        long idLong = hotel.getIdHotel();
        String idd = "" + idLong;
        return "redirect:/" + idd;
    }


    @GetMapping("/todos")
    @ApiOperation(value = "Retornar uma lista de hotéis")
    public List<Hotel> pegarTodosHoteis() {
        List<Hotel> hoteis = hotelService.pegarTodosHoteis();
        return hoteis;
    }
    @GetMapping("/cidade/hoteis/{id}")
    @ApiOperation(value = "Pegar hoteis por cidade")
    public List<Hotel> findAllHotelByCidade(@PathVariable("id")Long id){
        Cidade cidade = cidadeService.findCidadeById(id);
        List<Hotel> hoteis = hotelService.findAllHotelByCidade(cidade);
        return hoteis;
    }

}
