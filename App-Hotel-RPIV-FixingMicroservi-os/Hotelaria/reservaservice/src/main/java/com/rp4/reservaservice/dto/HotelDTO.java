package com.rp4.reservaservice.dto;

public class HotelDTO {
    private Long idHotel;

    public HotelDTO(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }
}
