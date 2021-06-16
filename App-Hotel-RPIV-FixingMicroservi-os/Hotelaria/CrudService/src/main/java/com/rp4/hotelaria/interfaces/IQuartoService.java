package com.rp4.hotelaria.interfaces;


import com.rp4.hotelaria.model.Quarto;

import java.util.List;

public interface IQuartoService {

    public void salvarQuarto(Quarto quarto);

    public Quarto getQuartoById(Long id);

    public Quarto atualizarQuarto(Quarto quarto);

    public void excluirQuarto(Long id);

    public List<Quarto> pegarTodosQuartos();

}
