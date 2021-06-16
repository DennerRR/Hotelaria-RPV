package com.rp4.servicos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @DateTimeFormat(pattern = "MM/dd/yyy")
    @Column(name = "data", nullable = false)
    private Date data;


    @OneToOne(cascade = CascadeType.ALL)
    private Servico servico;

    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;

    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;


    @Column(name = "valorReserva", nullable = false)
    private double valorReserva;

    public Reserva() {
    }

    public Reserva(Long id, Date data, Servico servico, Hotel hotel, Usuario usuario, double valorReserva) {
        this.id = id;
        this.data = data;
        this.servico = servico;
        this.hotel = hotel;
        this.usuario = usuario;
        this.valorReserva = valorReserva;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }
}
