package com.rp4.servicos.interfaces;

import com.rp4.servicos.model.Hotel;

public interface IHotelService {
    Hotel findHotelById(Long id);
}