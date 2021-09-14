package com.rp4.hotelaria.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_registro_hotel")
public class Hotel {

    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;

    @OneToMany
    private List<Quarto> quartos;

    @Column(name = "codEndereco")
    private String codEndereco;


    @Column(name = "descricao")
    private String descricao;

    @Column(name = "endereco")
    private String endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    public Hotel(Long idHotel, List<Quarto> quartos, String codEndereco, String descricao, String endereco, Cidade cidade) {
        this.idHotel = idHotel;
        this.quartos = quartos;
        this.codEndereco = codEndereco;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public Hotel() {


    }


    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(String codEndereco) {
        this.codEndereco = codEndereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
