package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Cidade;
import com.rp4.hotelaria.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findHotelByIdHotel(Long id);
    List<Hotel> findAllByCidade(Cidade cidade);
    //Iterable<Hotel> findAllByCidade(Cidade cidade);

}
