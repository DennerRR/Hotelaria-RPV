package com.rp4.consumoservice.interfaces;

import com.rp4.consumoservice.model.Consumo;
import com.rp4.consumoservice.model.Usuario;

import java.util.List;

public interface IConsumoService {
    void saveConsumo(Consumo consumo);
    public Consumo updateConsumo(Consumo consumo);
    public Consumo findConsumoById(Long id);
    public List<Consumo> findAllConsumosByUsuario(Usuario usuario);
    void deleteConsumo(Long id);
}
