package com.rp4.evolucaodb.interfaces;

import com.rp4.evolucaodb.model_new.Cidade;

import java.util.List;

public interface ICidadeService {

    void saveCidade(Cidade cidade);

    public Cidade updateCidade(Cidade cidade);

    public Cidade findCidadeById(Long id);


    public List<Cidade> findAllCidade();

    public void deleteCidade(Long id);

}
