package com.rp4.hotelaria.ServiceImplements;


import com.rp4.hotelaria.ProducerMensagem.ProdutoProducer;
import com.rp4.hotelaria.interfaces.IProdutoService;
import com.rp4.hotelaria.model.Produto;
import com.rp4.hotelaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class ProdutoServiceImplements implements IProdutoService {

    private ProdutoRepository produtoRepository;
    private ProdutoProducer produtoProducer;

    @Autowired
    public ProdutoServiceImplements(ProdutoRepository produtoRepository, ProdutoProducer produtoProducer){
        this.produtoRepository = produtoRepository;
        this.produtoProducer = produtoProducer;
    }

    @Override
    @Transactional
    public void salvarProduto(Produto produto) {
        Produto produtoSalvo =  produtoRepository.save(produto);
        produtoProducer.producerMensagem(produtoSalvo);
    }

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findProdutoById(id);
    }

    @Override
    public List<Produto> pegarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public void excluirProduto(Long id) {
    produtoRepository.deleteById(id);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
