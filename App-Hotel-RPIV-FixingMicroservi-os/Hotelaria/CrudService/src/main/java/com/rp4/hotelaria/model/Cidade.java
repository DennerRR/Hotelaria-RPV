package com.rp4.hotelaria.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_registro_cidade")
public class Cidade {

    @Id
    @Column(name = "id_Cidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_Cidade", nullable = false)
    private String nome;

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
