package com.rp4.hotelaria.dto;

public class CidadeDTO {
    private Long id;
    private String nome;
    private String ddd;

    public CidadeDTO() {
    }

    public CidadeDTO(Long id, String nome, String ddd) {
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
