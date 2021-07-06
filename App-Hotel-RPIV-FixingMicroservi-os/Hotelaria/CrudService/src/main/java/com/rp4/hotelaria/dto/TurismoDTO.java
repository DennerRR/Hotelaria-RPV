package com.rp4.hotelaria.dto;

import java.util.Date;

public class TurismoDTO {
    private Long id;
    private String nomeTurismo;
    private String descricao;
    private Long idHotel;
    private Date data;
    private double preco;

    public TurismoDTO() {
    }

    public TurismoDTO(Long id, String nomeTurismo, String descricao, Long idHotel, Date data, double preco) {
        this.id = id;
        this.nomeTurismo = nomeTurismo;
        this.descricao = descricao;
        this.idHotel = idHotel;
        this.data = data;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTurismo() {
        return nomeTurismo;
    }

    public void setNomeTurismo(String nomeTurismo) {
        this.nomeTurismo = nomeTurismo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
