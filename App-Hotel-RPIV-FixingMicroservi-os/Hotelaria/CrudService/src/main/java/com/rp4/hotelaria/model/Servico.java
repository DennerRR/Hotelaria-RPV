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
    private String nomeServico;

    @Column
    private double valor;

    public Servico() {
    }

    public Servico(Long id, String nomeServico, double valor) {
        this.id = id;
        this.nomeServico = nomeServico;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
