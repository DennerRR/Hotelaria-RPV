package com.rp4.evolucaodb.dto;

public class CidadeNewDTO {
    private Long id;
    private String nome;
    private String ddd;

    public CidadeNewDTO() {
    }

    public CidadeNewDTO(Long id, String nome, String ddd) {
        this.id = id;
        this.nome = nome;
        this.ddd = ddd;
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}
