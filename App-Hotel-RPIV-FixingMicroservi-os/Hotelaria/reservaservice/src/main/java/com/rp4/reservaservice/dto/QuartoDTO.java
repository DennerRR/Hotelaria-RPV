package com.rp4.reservaservice.dto;

import javax.persistence.Column;

public class QuartoDTO {
    private  Long idQuarto;

    private double preco;

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
