package com.rp4.hotelaria.dto;

public class ServicoDTO {
    private Long id;
    private String nome_servico;
    private double valor;

    public ServicoDTO(){

    }

    public ServicoDTO(Long id, String nome_servico, double valor) {
        this.id = id;
        this.nome_servico = nome_servico;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServico() {
        return nome_servico;
    }

    public void setServico(String servico) {
        this.nome_servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
