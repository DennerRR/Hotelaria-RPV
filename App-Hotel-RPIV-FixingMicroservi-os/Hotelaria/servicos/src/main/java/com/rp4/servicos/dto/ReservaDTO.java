package com.rp4.servicos.dto;

import java.util.Date;

public class ReservaDTO {
    private Long id;

    private Date data;

    private Long idServico;
    private Long idHotel;
    private Long idUsuario;

    private double valorReserva;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Date data, Long idServico, Long idHotel, Long idUsuario, double valorReserva) {
        this.id = id;
        this.data = data;
        this.idServico = idServico;
        this.idHotel = idHotel;
        this.idUsuario = idUsuario;
        this.valorReserva = valorReserva;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
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

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }
}
