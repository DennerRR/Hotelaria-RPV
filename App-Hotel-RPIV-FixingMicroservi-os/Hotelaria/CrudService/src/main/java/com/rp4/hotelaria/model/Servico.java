package com.rp4.hotelaria.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_serviços")
public class Servico {
    @Id
    @Column(name = "id_serviços")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String servico;

    @Column
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
