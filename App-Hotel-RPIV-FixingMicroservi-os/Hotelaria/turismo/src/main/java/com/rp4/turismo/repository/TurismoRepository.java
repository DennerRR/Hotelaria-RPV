package com.rp4.turismo.repository;

import com.rp4.turismo.model.Turismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurismoRepository extends JpaRepository<Turismo, Long> {
    Turismo findTurismoById(Long id);
}
