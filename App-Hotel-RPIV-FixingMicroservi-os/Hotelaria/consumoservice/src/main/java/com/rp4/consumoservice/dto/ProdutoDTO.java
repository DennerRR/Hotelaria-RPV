package com.rp4.consumoservice.dto;


public class ProdutoDTO {

    private Long id;
    private double preco;

    public ProdutoDTO(Long id, double preco) {
        this.id = id;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
