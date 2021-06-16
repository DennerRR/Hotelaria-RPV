package com.rp4.hotelaria.ServiceImplements;

import com.rp4.hotelaria.ProducerMensagem.QuartoProducer;
import com.rp4.hotelaria.interfaces.IQuartoService;
import com.rp4.hotelaria.model.Quarto;
import com.rp4.hotelaria.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuartoServiceImplements implements IQuartoService {

    private QuartoRepository quartoRepository;
    private QuartoProducer quartoProducer;

    @Autowired
    public QuartoServiceImplements(QuartoRepository quartoR, QuartoProducer quartoPM) {
        this.quartoRepository = quartoR;
        this.quartoProducer= quartoPM;
    }

    @Override
    @Transactional
    public void salvarQuarto(Quarto quarto) {
        Quarto quartoS = quartoRepository.save(quarto);
        quartoProducer.producerMensagem(quartoS);

    }

    @Override
    public Quarto getQuartoById(Long id) {
        return quartoRepository.findQuartoByIdQuarto(id);
    }


    @Override
    public Quarto atualizarQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    @Override
    public void excluirQuarto(Long id) {
        quartoRepository.deleteById(id);
    }

    @Override
    public List<Quarto> pegarTodosQuartos() {
        return quartoRepository.findAll();
    }
}
