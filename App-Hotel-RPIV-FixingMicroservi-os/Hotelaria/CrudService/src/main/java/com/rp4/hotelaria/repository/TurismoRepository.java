package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Turismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurismoRepository extends JpaRepository<Turismo, Long> {
        Turismo findTurismoById(Long id);
        List<Turismo> findAllByHotel(Hotel hotel);
}
