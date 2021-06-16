package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findHotelByIdHotel(Long id);

}
