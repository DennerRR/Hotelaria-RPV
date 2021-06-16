package com.rp4.reservaservice.interfaces;

import com.rp4.reservaservice.model.Hotel;

public interface IHotelService {
    Hotel findHotelById(Long id);
}
