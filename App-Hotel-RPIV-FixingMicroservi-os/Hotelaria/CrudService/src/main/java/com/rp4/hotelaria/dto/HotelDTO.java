package com.rp4.hotelaria.dto;





public class HotelDTO {

    private Long idHotel;
    private String codEndereco;
    private String descricao;
    private String endereco;
    private long idCidade;

    public HotelDTO() {

    }

    public HotelDTO(Long idHotel, String codEndereco, String descricao, String endereco, long idCidade) {
        this.idHotel = idHotel;
        this.codEndereco = codEndereco;
        this.descricao = descricao;
        this.endereco = endereco;
        this.idCidade = idCidade;


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

    public long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }
}