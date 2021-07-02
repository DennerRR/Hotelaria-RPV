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

    public CidadeServiceImplements(CidadeRepository cidadeRepository, CidadeProducer cidadeProducer) {
        this.cidadeRepository = cidadeRepository;
        this.cidadeProducer = cidadeProducer;
    }

    @Override
    public void saveCidade(Cidade cidade) {
        cidadeRepository.save(cidade);
        cidadeProducer.producerMensagem(cidade);
    }

    @Override
    public Cidade updateCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public Cidade findCidadeById(Long id) {
        return cidadeRepository.findCidadeById(id);
    }

    @Override
    public List<Cidade> findAllCidade() {
        return cidadeRepository.findAll();
    }

    @Override
    public void deleteCidade(Long id) {
        cidadeRepository.deleteById(id);
    }
}
