package com.rp4.hotelaria.interfaces;

import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Turismo;

import java.util.List;

public interface ITurismoService {

    public void salvarTurismo(Turismo turismo);
    public Turismo getTurismoById(Long id);
    public Turismo atualizarTurismo(Turismo turismo);
    public void excluirTurismo(Long id);
    public List<Turismo> pegarTodosTurismo();
    public List<Turismo> findAllTurismoByHotel(Hotel hotel);
}
