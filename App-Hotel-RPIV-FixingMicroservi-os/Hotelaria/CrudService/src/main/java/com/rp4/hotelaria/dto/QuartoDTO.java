package com.rp4.hotelaria.dto;

public class QuartoDTO {

    private Long idQuarto;
    private int numeroDoQuarto;
    private double preco;
    private String descricao;
    private String adicionalDoQuarto;
    private Long idHotel;

    public QuartoDTO() {

    }

    public QuartoDTO(Long idQuarto, int numeroDoQuarto, double preco, String descricao, String adicionalDoQuarto, Long idHotel) {
        this.idQuarto = idQuarto;
        this.numeroDoQuarto = numeroDoQuarto;
        this.preco = preco;
        this.descricao = descricao;
        this.adicionalDoQuarto = adicionalDoQuarto;
        this.idHotel = idHotel;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(int numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAdicionalDoQuarto() {
        return adicionalDoQuarto;
    }

    public void setAdicionalDoQuarto(String adicionalDoQuarto) {
        this.adicionalDoQuarto = adicionalDoQuarto;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }
}
