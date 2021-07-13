package com.rp4.turismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {
    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany
    private List<Reserva> reservas;

    public Usuario() {
    }

    public Usuario(Long id, String nome, List<Reserva> reservas) {
        this.id = id;
        this.nome = nome;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}