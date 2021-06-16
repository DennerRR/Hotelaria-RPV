package com.rp4.reservaservice.ServiceImplements;

import com.rp4.reservaservice.interfaces.IHotelService;
import com.rp4.reservaservice.model.Hotel;
import com.rp4.reservaservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImplements implements IHotelService {
    private HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImplements(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel findHotelById(Long id) {
        return hotelRepository.findHotelByIdHotel(id);
    }
}
