package com.rp4.evolucaodb.interfaces;

import com.rp4.evolucaodb.model_new.CidadeNew;

import java.util.List;

public interface ICidadeNewService {

    void saveCidade(CidadeNew cidadeNew);

    public CidadeNew updateCidade(CidadeNew cidadeNew);

    public CidadeNew findCidadeById(Long id);


    public List<CidadeNew> findAllCidade();

    public void deleteCidade(Long id);

}
