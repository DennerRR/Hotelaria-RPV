package com.rp4.hotelaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "tbl_registro_quarto")
public class Quarto {

    @Id
    @Column(name = "id_quarto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuarto;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

    @Column(name = "numeroDoQuarto")
    private int numeroDoQuarto;

    @Column(name = "preco")
    private double preco;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "adicionalDoQuarto")
    private String adicionalDoQuarto;



    public Quarto() {
    }

    public Quarto(Long idQuarto, Hotel hotel, int numeroDoQuarto, double preco, String descricao, String adicionalDoQuarto) {
        this.idQuarto = idQuarto;
        this.hotel = hotel;
        this.numeroDoQuarto = numeroDoQuarto;
        this.preco = preco;
        this.descricao = descricao;
        this.adicionalDoQuarto = adicionalDoQuarto;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(int numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAdicionalDoQuarto() {
        return adicionalDoQuarto;
    }

    public void setAdicionalDoQuarto(String adicionalDoQuarto) {
        this.adicionalDoQuarto = adicionalDoQuarto;
    }
}
