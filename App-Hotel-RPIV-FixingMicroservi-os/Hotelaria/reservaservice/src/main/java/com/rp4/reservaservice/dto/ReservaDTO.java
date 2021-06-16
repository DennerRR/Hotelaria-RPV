package com.rp4.reservaservice.dto;

import com.rp4.reservaservice.model.Quarto;

import java.util.Date;

public class ReservaDTO {
    private Long id;

    private Date dataInicio;

    private Date dataFinal;

    private Long idQuarto;
    private Long idHotel;
    private Long idUsuario;

    private double valorReserva;


    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Date dataInicio, Date dataFinal, Long idQuarto, Long idHotel, Long idUsuario, double valorReserva) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.idQuarto = idQuarto;
        this.idHotel = idHotel;
        this.idUsuario = idUsuario;
        this.valorReserva = valorReserva;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }
}
