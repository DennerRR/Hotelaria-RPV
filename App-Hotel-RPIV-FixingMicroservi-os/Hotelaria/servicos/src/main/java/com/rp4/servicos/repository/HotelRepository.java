package com.rp4.servicos.repository;

import com.rp4.servicos.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findHotelByIdHotel(Long id);
}
