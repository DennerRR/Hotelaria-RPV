package com.rp4.consumoservice.dto;


import com.rp4.consumoservice.model.Produto;

import java.util.Date;

public class ConsumoDTO {
    private Long id;
    private Date data;
    private Long idProduto;
    private Long idUsuario;


    public ConsumoDTO() {
    }

    public ConsumoDTO(Long id, Date data, Long idProduto, Long idUsuario) {
        this.id = id;
        this.data = data;
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
