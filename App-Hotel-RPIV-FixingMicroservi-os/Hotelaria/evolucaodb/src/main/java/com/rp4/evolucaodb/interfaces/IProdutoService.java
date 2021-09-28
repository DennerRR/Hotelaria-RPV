package com.rp4.evolucaodb.interfaces;

import com.rp4.evolucaodb.model_new.Produto;

import java.util.List;

public interface IProdutoService {

    public void salvarProduto(Produto produto);

    public Produto getProdutoById(Long id);

    public List<Produto> pegarTodosProdutos();

    public void excluirProduto(Long id);

    public Produto atualizarProduto(Produto produto);

}
