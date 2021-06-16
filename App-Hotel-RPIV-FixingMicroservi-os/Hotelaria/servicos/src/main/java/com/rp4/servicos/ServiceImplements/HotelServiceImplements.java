package com.rp4.servicos.ServiceImplements;

import com.rp4.servicos.interfaces.IHotelService;
import com.rp4.servicos.model.Hotel;
import com.rp4.servicos.repository.HotelRepository;
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