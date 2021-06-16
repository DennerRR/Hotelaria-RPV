package com.rp4.reservaservice.model;

import javax.persistence.*;

@Entity
public class Quarto {

    @Id
    @Column(name = "id_quarto")
    private Long idQuarto;

    @Column(name = "preco")
    private double preco;

    public Quarto() {
    }

    public Quarto(Long idQuarto, double preco) {
        this.idQuarto = idQuarto;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }
}
