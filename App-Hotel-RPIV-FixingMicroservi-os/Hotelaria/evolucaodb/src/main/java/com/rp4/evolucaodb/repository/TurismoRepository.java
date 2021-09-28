package com.rp4.evolucaodb.repository;

import com.rp4.evolucaodb.model.Hotel;
import com.rp4.evolucaodb.model.Turismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurismoRepository extends JpaRepository<Turismo, Long> {
        Turismo findTurismoById(Long id);
        List<Turismo> findAllByHotel(Hotel hotel);
}
