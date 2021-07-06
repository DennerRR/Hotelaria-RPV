package com.rp4.turismo.DTO;

import java.util.Date;

public class ReservaDTO {
    private Long id;
    private Long idUsuario;
    private Long idTurismo;
    private double preco;
    private Date data;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Long idUsuario, Long idTurismo, double preco, Date data) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idTurismo = idTurismo;
        this.preco = preco;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTurismo() {
        return idTurismo;
    }

    public void setIdTurismo(Long idTurismo) {
        this.idTurismo = idTurismo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
