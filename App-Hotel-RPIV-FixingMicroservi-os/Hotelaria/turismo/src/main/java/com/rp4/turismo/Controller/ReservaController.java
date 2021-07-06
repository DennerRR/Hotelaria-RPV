package com.rp4.turismo.Controller;


import com.rp4.turismo.DTO.ReservaDTO;
import com.rp4.turismo.interfaces.IReservaService;
import com.rp4.turismo.interfaces.ITurismoService;
import com.rp4.turismo.interfaces.IUsuarioService;
import com.rp4.turismo.model.Reserva;
import com.rp4.turismo.model.Turismo;
import com.rp4.turismo.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST turismo")
@CrossOrigin(origins = "*")
public class ReservaController {
    private IReservaService reservaService;
    private ITurismoService turismoService;
    private IUsuarioService usuarioService;

    @Autowired
    public ReservaController(IReservaService reservaService, ITurismoService turismoService, IUsuarioService usuarioService) {
        this.reservaService = reservaService;
        this.turismoService = turismoService;
        this.usuarioService = usuarioService;
    }
    @PostMapping("/salvar")
    @ApiOperation(value = "Cadastra uma reserva")
    public void salvarReserva(@RequestBody ReservaDTO reservaDTO) {
        Usuario usuario = usuarioService.findUsuarioById(reservaDTO.getIdUsuario());
        Turismo turismo = turismoService.findTurismoById(reservaDTO.getIdTurismo());
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setTurismo(turismo);
        reserva.setId(reservaDTO.getId());
        reserva.setData(reservaDTO.getData());
        reserva.setPreco(reservaDTO.getPreco());
        reservaService.saveReserva(reserva);
    }

    @GetMapping("/reserva/{id}")
    public Reserva getReservaById(@PathVariable("id") Long id) {
        Reserva reserva = reservaService.findReservaById(id);
        return reserva;
    }

    @PutMapping("/reserva/atualizar")
    @ApiOperation(value = "Atualizar uma reserva de turismo")
    public ResponseEntity<?> updateReserva(@RequestBody Reserva reserva) {
        Reserva reserva1 = reservaService.updateReserva(reserva);
        return new ResponseEntity<>(reserva1, HttpStatus.OK);
    }


    @GetMapping("/usuario/encontrar/{id}")
    public ResponseEntity<?> getReservaByUsuarioId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        List<Reserva> reservas = reservaService.findAllReservaByUsuario(usuario);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

}
