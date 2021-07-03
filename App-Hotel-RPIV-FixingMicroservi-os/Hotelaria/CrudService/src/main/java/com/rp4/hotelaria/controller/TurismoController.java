package com.rp4.hotelaria.controller;


import com.rp4.hotelaria.dto.HotelDTO;
import com.rp4.hotelaria.dto.TurismoDTO;
import com.rp4.hotelaria.interfaces.IHotelService;
import com.rp4.hotelaria.interfaces.ITurismoService;
import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Turismo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Turismo")

@Api(value = "API Rest Turismo")

//Liberar todos domínios para acessar essa API
@CrossOrigin(origins = "*")
public class TurismoController {
    private ITurismoService turismoService;
    private IHotelService hotelService;

    public TurismoController(ITurismoService turismoService, IHotelService hotelService) {
        this.turismoService = turismoService;
        this.hotelService = hotelService;
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Salvar Turismo")
    public void saveTurismo(@RequestBody TurismoDTO turismoDTO) {
        Hotel hotel = hotelService.getHotelById(turismoDTO.getIdHotel());
        Turismo turismo = new Turismo();
        turismo.setNomeTurismo(turismoDTO.getNomeTurismo());
        turismo.setDescricao(turismoDTO.getDescricao());
        turismo.setData(turismoDTO.getData());
        turismo.setHotel(hotel);
        turismoService.salvarTurismo(turismo);
    }


    @GetMapping("/turismo/{id}")
    @ApiOperation(value = "Retorna um turismo")
    public ResponseEntity<?> pegarTurismoPeloId(@PathVariable("id") Long id) {
        Turismo turismo = turismoService.getTurismoById(id);
        return new ResponseEntity<>(turismo, HttpStatus.OK);
    }

    @PutMapping("/turismo/atualizar")
    @ApiOperation(value = "Atualizar turismo")
    public Turismo atualizarTurismo(@RequestBody Turismo turismo) {
        return turismoService.atualizarTurismo(turismo);
    }

    @DeleteMapping("/turismo/excluir/{id}")
    @ApiOperation(value = "Deletar turismo")
    public void deleteTurismo(@PathVariable("id") Long id) {
        turismoService.excluirTurismo(id);
    }

    @GetMapping("/todos")
    @ApiOperation(value = "Retornar uma lista de turismo")
    public List<Turismo> pegarTodosTurismos() {
        List<Turismo> turismos = turismoService.pegarTodosTurismo();
        return turismos;
    }

    @GetMapping("/hoteis/turismos/{id}")
    @ApiOperation(value = "Pegar turismos por hotel")
    public List<Turismo> findAllTurismoByHotel(@PathVariable("id") Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        List<Turismo> turismos=turismoService.findAllTurismoByHotel(hotel);

        return turismos;
    }

}
