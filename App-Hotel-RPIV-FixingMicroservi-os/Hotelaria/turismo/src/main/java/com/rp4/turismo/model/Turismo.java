package com.rp4.turismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Turismo {

    @Id
    @Column(name = "id_turismo")
    private Long id;

    @Column(name = "preco")
    private double preco;

    @OneToMany
    private List<Reserva> reservas;

    public Turismo() {
    }

    public Turismo(Long id, double preco, List<Reserva> reservas) {
        this.id = id;
        this.preco = preco;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
