package com.rp4.hotelaria.interfaces;

import com.rp4.hotelaria.model.Servico;

import java.util.List;

public interface  IServicoService {
    public void salvarServico(Servico servico);
    public Servico getServicoById(Long id);
    public Servico atualizarServico(Servico servico);
    public void excluirServico(Long id);
    public List<Servico> pegarTodosServicos();
}
