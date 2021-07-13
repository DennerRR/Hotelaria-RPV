package com.rp4.hotelaria.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_registro_cidade")
public class Cidade implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @Column(name = "ddd")
    private String ddd;

    @OneToMany()
    private List<Hotel> hoteis;

    public Cidade() {
    }

    public Cidade(long id, String nome, String ddd, List<Hotel> hoteis) {
        this.id = id;
        this.nome = nome;
        this.ddd = ddd;
        this.hoteis = hoteis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void setHoteis(List<Hotel> hoteis) {
        this.hoteis = hoteis;
    }
}
