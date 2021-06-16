package com.rp4.consumoservice.interfaces;

import com.rp4.consumoservice.model.Produto;

public interface IProdutoService {
    Produto findProdutoById(Long id);
}
