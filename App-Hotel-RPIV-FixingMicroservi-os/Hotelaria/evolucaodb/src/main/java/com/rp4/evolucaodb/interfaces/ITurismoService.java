package com.rp4.evolucaodb.interfaces;

import com.rp4.evolucaodb.model_new.Hotel;
import com.rp4.evolucaodb.model_new.Turismo;

import java.util.List;

public interface ITurismoService {

    public void salvarTurismo(Turismo turismo);
    public Turismo getTurismoById(Long id);
    public Turismo atualizarTurismo(Turismo turismo);
    public void excluirTurismo(Long id);
    public List<Turismo> pegarTodosTurismo();
    public List<Turismo> findAllTurismoByHotel(Hotel hotel);
}
