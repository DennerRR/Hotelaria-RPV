package com.rp4.consumoservice.ServiceImplements;

import com.rp4.consumoservice.interfaces.IProdutoService;
import com.rp4.consumoservice.model.Produto;
import com.rp4.consumoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImplements implements IProdutoService {
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImplements(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto findProdutoById(Long id) {
        return produtoRepository.findProdutoById(id);
    }
}
