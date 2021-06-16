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

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "endereco")
    private String endereco;


    public Hotel() {

    }

    public Hotel(Long idHotel, String codEndereco, String cidade, String descricao, String endereco) {
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
