package com.rp4.evolucaodb.interfaces;

import java.util.List;

import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;

public interface IHotelService {

    public void salvarHotel(Hotel hotel);

    public Hotel getHotelById(Long id);

    public Hotel atualizarHotel(Hotel hotel);

    public void excluirHotel(Long id);

    public List<Hotel> pegarTodosHoteis();

    public List<Hotel> findAllHotelByCidade(Cidade cidade);


}
