package com.rp4.servicos.controller;


import com.rp4.servicos.dto.ReservaDTO;
import com.rp4.servicos.interfaces.IHotelService;
import com.rp4.servicos.interfaces.IReservaService;
import com.rp4.servicos.interfaces.IServicoService;
import com.rp4.servicos.interfaces.IUsuarioService;
import com.rp4.servicos.model.Hotel;
import com.rp4.servicos.model.Reserva;
import com.rp4.servicos.model.Servico;
import com.rp4.servicos.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST reservas de serviços")
@CrossOrigin(origins = "*")
public class ReservaController {
    private IReservaService reservaService;
    private IServicoService servicoService;
    private IUsuarioService usuarioService;
    private IHotelService hotelService;

    public ReservaController(IReservaService reservaService, IServicoService servicoService, IUsuarioService usuarioService, IHotelService hotelService) {
        this.reservaService = reservaService;
        this.servicoService = servicoService;
        this.usuarioService = usuarioService;
        this.hotelService = hotelService;
    }


    @PostMapping("/salvar")
    @ApiOperation(value = "Cadastra uma reserva de serviço")
    public void salvarReserva(@RequestBody ReservaDTO reservaDTO) {
        Servico servico= servicoService.findServicoById(reservaDTO.getIdServico());
        Hotel hotel = hotelService.findHotelById(reservaDTO.getIdHotel());
        Usuario usuario = usuarioService.findUsuarioById(reservaDTO.getIdUsuario());
        Reserva reserva = new Reserva();
        reserva.setHotel(hotel);
        reserva.setUsuario(usuario);
        reserva.setServico(servico);

        reserva.setId(reservaDTO.getId());
        reserva.setValorReserva(reservaDTO.getValorReserva());
        reservaService.saveReserva(reserva);

    }

    @PutMapping("/reserva/atualizar")
    @ApiOperation(value = "Atualizar uma reserva de serviço")
    public ResponseEntity<?> updateReserva(@RequestBody Reserva reserva) {
        Reserva atualizarReserva = reservaService.updateReserva(reserva);
        return new ResponseEntity<>(atualizarReserva, HttpStatus.OK);
    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<?> getReservaById(@PathVariable("id") Long id) {
        Reserva reserva = reservaService.findReservaById(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
    @GetMapping("/usuario/encontrar/{id}")

    public ResponseEntity<?> getReservaByUsuarioId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        List<Reserva> reservas = reservaService.findAllReservaByUsuario(usuario);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

}
