package com.rp4.hotelaria.dto;

public class ProdutoDTO {

    private long id;
    private String nome;
    private int quantidade;
    private double valor;

    public ProdutoDTO(){
    }

    public ProdutoDTO(String nome, int quantidade, double valor){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
