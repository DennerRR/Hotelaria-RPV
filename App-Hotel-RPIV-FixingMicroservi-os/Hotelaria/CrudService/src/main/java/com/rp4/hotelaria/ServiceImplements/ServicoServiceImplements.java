package com.rp4.hotelaria.ServiceImplements;

import com.rp4.hotelaria.ProducerMensagem.ServicoProducer;
import com.rp4.hotelaria.interfaces.IServicoService;
import com.rp4.hotelaria.model.Servico;
import com.rp4.hotelaria.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServicoServiceImplements implements IServicoService {

    private ServicoRepository servicoRepository;
    private ServicoProducer servicoProducer;

    @Autowired
    public ServicoServiceImplements(ServicoRepository servicoRepository, ServicoProducer servicoProducer){
        this.servicoRepository = servicoRepository;
        this.servicoProducer = servicoProducer;
    }


    @Override
    @Transactional
    public void salvarServico(Servico servico) {
        servicoRepository.save(servico);
        servicoProducer.producerMensagem(servico);
    }

    @Override
    public Servico getServicoById(Long id) {
        return servicoRepository.findServicoById(id);
    }

    @Override
    public Servico atualizarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    @Override
    public void excluirServico(Long id) {
        servicoRepository.deleteById(id);
    }

    @Override
    public List<Servico> pegarTodosServicos() {
        return servicoRepository.findAll();
    }
}
