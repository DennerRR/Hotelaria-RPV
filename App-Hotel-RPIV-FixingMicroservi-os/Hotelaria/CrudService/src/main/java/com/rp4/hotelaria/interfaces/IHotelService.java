package com.rp4.hotelaria.interfaces;

import java.util.List;

import com.rp4.hotelaria.model.Hotel;

public interface IHotelService {

    public void salvarHotel(Hotel hotel);

    public Hotel getHotelById(Long id);

    public Hotel atualizarHotel(Hotel hotel);

    public void excluirHotel(Long id);

    public List<Hotel> pegarTodosHoteis();


}
