package com.rp4.reservaservice.repository;

import com.rp4.reservaservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findHotelByIdHotel(Long id);
}
