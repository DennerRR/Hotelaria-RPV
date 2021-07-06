package com.rp4.turismo.ServiceImplements;

import com.rp4.turismo.interfaces.ITurismoService;
import com.rp4.turismo.model.Turismo;
import com.rp4.turismo.repository.TurismoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurismoServiceImplements implements ITurismoService {

    private TurismoRepository turismoRepository;

    @Autowired
    public TurismoServiceImplements(TurismoRepository turismoRepository) {
        this.turismoRepository = turismoRepository;
    }

    @Override
    public Turismo findTurismoById(Long id) {
        return turismoRepository.findTurismoById(id);
    }
}
