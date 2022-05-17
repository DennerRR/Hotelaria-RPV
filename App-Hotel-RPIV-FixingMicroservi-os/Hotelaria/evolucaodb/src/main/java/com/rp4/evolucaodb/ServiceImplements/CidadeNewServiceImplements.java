package com.rp4.evolucaodb.ServiceImplements;

import com.rp4.evolucaodb.ProducerMensagem.CidadeNewProducer;
import com.rp4.evolucaodb.interfaces.ICidadeNewService;
import com.rp4.evolucaodb.model_new.CidadeNew;
import com.rp4.evolucaodb.repository.CidadeNewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeNewServiceImplements implements ICidadeNewService {

    private CidadeNewRepository cidadeRepository;
    private CidadeNewProducer cidadeProducer;

    public CidadeNewServiceImplements(CidadeNewRepository cidadeRepository, CidadeNewProducer cidadeProducer) {
        this.cidadeRepository = cidadeRepository;
        this.cidadeProducer = cidadeProducer;
    }

    @Override
    public void saveCidade(CidadeNew cidadeNew) {
        cidadeRepository.save(cidadeNew);
        cidadeProducer.producerMensagem(cidadeNew);
    }

    @Override
    public CidadeNew updateCidade(CidadeNew cidade) {
        return cidadeRepository.save(cidade);
    }
    

    @Override
    public CidadeNew findCidadeById(Long id) {
        return cidadeRepository.findCidadeById(id);
    }

    @Override
    public List<CidadeNew> findAllCidade() {
        return cidadeRepository.findAll();
    }

    @Override
    public void deleteCidade(Long id) {
        cidadeRepository.deleteById(id);
    }
}
