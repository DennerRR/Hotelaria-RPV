package com.rp4.hotelaria.ServiceImplements;

import com.rp4.hotelaria.ProducerMensagem.TurismoProducer;
import com.rp4.hotelaria.interfaces.ITurismoService;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Turismo;
import com.rp4.hotelaria.repository.TurismoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurismoServiceImplements implements ITurismoService {

    TurismoRepository turismoRepository;
    TurismoProducer turismoProducer;

    public TurismoServiceImplements(TurismoRepository turismoRepository, TurismoProducer turismoProducer) {
        this.turismoRepository = turismoRepository;
        this.turismoProducer = turismoProducer;
    }

    @Override
    public void salvarTurismo(Turismo turismo) {
        turismoRepository.save(turismo);
        turismoProducer.producerMensagem(turismo);
    }

    @Override
    public Turismo getTurismoById(Long id) {
        return turismoRepository.findTurismoById(id);
    }

    @Override
    public Turismo atualizarTurismo(Turismo turismo) {
        return turismoRepository.save(turismo);
    }

    @Override
    public void excluirTurismo(Long id) {
        turismoRepository.deleteById(id);
    }

    @Override
    public List<Turismo> pegarTodosTurismo() {
        return turismoRepository.findAll();
    }

    @Override
    public List<Turismo> findAllTurismoByHotel(Hotel hotel) {
        return turismoRepository.findAllByHotel(hotel);
    }
}
