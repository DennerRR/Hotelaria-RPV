package com.rp4.hotelaria.ServiceImplements;

import com.rp4.hotelaria.ProducerMensagem.CidadeProducer;
import com.rp4.hotelaria.interfaces.ICidadeService;
import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImplements implements ICidadeService {

    private CidadeRepository cidadeRepository;
    private CidadeProducer cidadeProducer;
    @Override
    public void saveCidade(Cidade cidade) {

    }

    @Override
    public Cidade updateCidade(Cidade cidade) {
        return null;
    }

    @Override
    public Cidade findCidadeById(Long id) {
        return null;
    }

    @Override
    public List<Cidade> findAllCidade() {
        return null;
    }

    @Override
    public void deleteCidade(Long id) {

    }
}
