package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.HotelDTO;
import com.rp4.hotelaria.interfaces.IHotelService;
import com.rp4.hotelaria.interfaces.IQuartoService;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Quarto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteis")

public class HotelController {
    private IHotelService hotelService;
    private IQuartoService quartoService;

    public HotelController(IHotelService service,IQuartoService quartoService) {
        this.hotelService = service;
        this.quartoService = quartoService;
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Salvar hotel")
    public void saveHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setCidade(hotelDTO.getCidade());
        hotel.setDescricao(hotelDTO.getDescricao());
        hotel.setEndereco(hotelDTO.getEndereco());
        hotelService.salvarHotel(hotel);
    }
    @PostMapping("/QuartoHotel/{id}")
    public void quartoHotel(@PathVariable("id") Long id, Quarto quarto){
        Hotel hotel = hotelService.getHotelById(id);
        quarto.setHotel(hotel);
        quartoService.salvarQuarto(quarto);
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

    @DeleteMapping("/hotel/excluir/{id}")
    @ApiOperation(value = "Deletar hotel")
    public void deleteHotel(@PathVariable("id") Long id) {
        hotelService.excluirHotel(id);
    }

    @GetMapping("/todos")
    @ApiOperation(value = "Retornar uma lista de hotéis")
    public List<Hotel> pegarTodosHoteis() {
        List<Hotel> hoteis = hotelService.pegarTodosHoteis();
        return hoteis;
    }

}
