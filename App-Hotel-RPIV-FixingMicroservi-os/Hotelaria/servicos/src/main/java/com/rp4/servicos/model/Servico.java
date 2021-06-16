package com.rp4.servicos.model;

import javax.persistence.*;

@Entity
public class Servico {

    @Id
    @Column(name = "id_serviços")
    private Long id;

    @Column(name = "nome_serviço")
    private String servico;

    @Column(name = "valor")
    private double valor;

    public Servico() {
    }

    public Servico(Long id, String servico, double valor) {
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
