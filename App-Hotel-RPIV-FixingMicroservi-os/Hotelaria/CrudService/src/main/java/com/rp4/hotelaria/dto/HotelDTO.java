package com.rp4.hotelaria.dto;



import java.util.List;

public class HotelDTO {

    private Long idHotel;
    private String codEndereco;
    private String cidade;
    private String descricao;
    private String endereco;


    public HotelDTO() {

    }

    public HotelDTO(Long idHotel, String codEndereco, String cidade, String descricao, String endereco) {
        this.idHotel = idHotel;
        this.codEndereco = codEndereco;
        this.cidade = cidade;
        this.descricao = descricao;
        this.endereco = endereco;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
