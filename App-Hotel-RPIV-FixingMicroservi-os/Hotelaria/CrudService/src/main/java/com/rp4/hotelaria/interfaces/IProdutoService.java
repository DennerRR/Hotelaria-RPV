package com.rp4.hotelaria.interfaces;

import com.rp4.hotelaria.model.Produto;

import java.util.List;

public interface IProdutoService {

    public void salvarProduto(Produto produto);

    public Produto getProdutoById(Long id);

    public List<Produto> pegarTodosProdutos();

    public void excluirProduto(Long id);

    public Produto atualizarProduto(Produto produto);

}
