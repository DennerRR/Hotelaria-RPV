package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Quarto findQuartoByIdQuarto(Long id);

    List<Quarto> findQuartoByHotel(Hotel hotel);
}
