package com.rp4.reservaservice.ServiceImplements;

import com.rp4.reservaservice.interfaces.IQuartoService;
import com.rp4.reservaservice.model.Quarto;
import com.rp4.reservaservice.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartoServiceImplements implements IQuartoService {
    private QuartoRepository quartoRepository;

    @Autowired
    public QuartoServiceImplements(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    @Override
    public Quarto findQuartoById(Long id) {
        return quartoRepository.findQuartoByIdQuarto(id);
    }
}
