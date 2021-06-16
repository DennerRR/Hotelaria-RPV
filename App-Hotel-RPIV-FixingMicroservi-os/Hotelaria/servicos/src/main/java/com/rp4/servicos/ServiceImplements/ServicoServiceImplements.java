package com.rp4.servicos.ServiceImplements;

import com.rp4.servicos.interfaces.IServicoService;
import com.rp4.servicos.model.Servico;
import com.rp4.servicos.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoServiceImplements implements IServicoService {
    private ServicoRepository servicoRepository;

    @Autowired
    public ServicoServiceImplements(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Override
    public Servico findServicoById(Long id) {
        return servicoRepository.findServicoById(id);
    }
}
