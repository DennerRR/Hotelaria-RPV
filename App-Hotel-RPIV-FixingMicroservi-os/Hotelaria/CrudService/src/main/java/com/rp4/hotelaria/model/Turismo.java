package com.rp4.hotelaria.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_registro_turismo")
public class Turismo {

    @Id
    @Column(name = "id_turismo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_turismo")
    private String nomeTurismo;

    @Column(name = "descricao_turismo")
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hotel hotel;

    @Column(name = "data")
    private Date data;



    public Turismo() {
    }

    public Turismo(Long id, String nomeTurismo, String descricao, Hotel hotel, Date data) {
        this.id = id;
        this.nomeTurismo = nomeTurismo;
        this.descricao = descricao;
        this.hotel = hotel;
        this.data = data;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}