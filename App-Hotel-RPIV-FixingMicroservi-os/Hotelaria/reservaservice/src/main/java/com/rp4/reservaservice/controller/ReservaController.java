package com.rp4.reservaservice.controller;

import com.rp4.reservaservice.dto.ReservaDTO;
import com.rp4.reservaservice.interfaces.IHotelService;
import com.rp4.reservaservice.interfaces.IQuartoService;
import com.rp4.reservaservice.interfaces.IReservaService;
import com.rp4.reservaservice.interfaces.IUsuarioService;
import com.rp4.reservaservice.model.Hotel;
import com.rp4.reservaservice.model.Quarto;
import com.rp4.reservaservice.model.Reserva;
import com.rp4.reservaservice.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST reservas")
@CrossOrigin(origins = "*")
public class ReservaController {
    private IReservaService reservaService;
    private IQuartoService quartoService;
    private IUsuarioService usuarioService;
    private IHotelService hotelService;

    @Autowired
    public ReservaController(IReservaService service,IQuartoService quartoService,IUsuarioService usuarioService,IHotelService hotelService) {
        this.reservaService = service;
        this.quartoService = quartoService;
        this.usuarioService = usuarioService;
        this.hotelService = hotelService;
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Cadastra uma reserva")
    public void salvarReserva(@RequestBody ReservaDTO reservaDTO) {
        Hotel hotel = hotelService.findHotelById(reservaDTO.getIdHotel());
        Usuario usuario = usuarioService.findUsuarioById(reservaDTO.getIdUsuario());
        Quarto quarto = quartoService.findQuartoById(reservaDTO.getIdQuarto());
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setQuarto(quarto);
        reserva.setHotel(hotel);
        reserva.setId(reservaDTO.getId());
        reserva.setDataInicio(reservaDTO.getDataInicio());
        reserva.setDataFinal(reservaDTO.getDataFinal());

        reserva.setValorReserva(reservaDTO.getValorReserva());
        reservaService.saveReserva(reserva);

    }


    @GetMapping("/reserva/{id}")
    public Reserva getReservaById(@PathVariable("id") Long id) {
        Reserva reserva = reservaService.findReservaById(id);
       return reserva;
    }
    @GetMapping("/usuario/encontrar/{id}")
    public ResponseEntity<?> getReservaByUsuarioId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        List<Reserva> reservas = reservaService.findAllReservaByUsuario(usuario);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

}
