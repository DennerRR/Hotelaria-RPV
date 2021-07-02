package com.rp4.hotelaria.interfaces;

import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Produto;

import java.util.List;

public interface ICidadeService {

    void saveCidade(Cidade cidade);

    public Cidade updateCidade(Cidade cidade);

    public Cidade findCidadeById(Long id);


    public List<Cidade> findAllCidade();

    public void deleteCidade(Long id);

}
