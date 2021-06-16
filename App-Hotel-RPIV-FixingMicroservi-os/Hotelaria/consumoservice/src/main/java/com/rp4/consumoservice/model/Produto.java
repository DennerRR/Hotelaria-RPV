package com.rp4.consumoservice.model;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    private Long id;

    @Column(name = "valor")
    private double valor;

    public Produto() {
    }

    public Produto(Long id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
