package com.rp4.hotelaria.dto;

public class ServicoDTO {
    private Long id;
    private String servico;
    private double valor;

    public ServicoDTO(){

    }

    public ServicoDTO(Long id, String servico, double valor) {
        this.id = id;
        this.servico = servico;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
