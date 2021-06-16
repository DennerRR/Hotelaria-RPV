package com.rp4.servicos.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {
    @Id
    @Column(name = "id_hotel")
    private Long idHotel;




    public Hotel() {
    }
    public Hotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }
}
