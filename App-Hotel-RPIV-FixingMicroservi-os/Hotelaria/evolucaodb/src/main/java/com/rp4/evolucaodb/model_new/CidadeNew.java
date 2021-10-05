package com.rp4.evolucaodb.model_new;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cidade")
public class CidadeNew {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "ddd")
    private String ddd;

    @OneToMany()
    private List<Hotel> hoteis;

    public CidadeNew() {
    }

    public CidadeNew(long id, String nome, String ddd, List<Hotel> hoteis) {
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
