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
    private String nome_servico;

    @Column
    private double valor;

    public Servico() {
    }

    public Servico(Long id, String nome_servico, double valor) {
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

    public String getNomeServico() {
        return nome_servico;
    }

    public void setNomeServico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
