package com.rp4.servicos.interfaces;

import com.rp4.servicos.model.Servico;

public interface IServicoService {
    Servico findServicoById(Long id);
}
