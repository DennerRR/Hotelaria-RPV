package com.rp4.evolucaodb.repository;

import com.rp4.evolucaodb.model.Cidade;
import com.rp4.evolucaodb.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findHotelByIdHotel(Long id);
    List<Hotel> findAllByCidade(Cidade cidade);

}
