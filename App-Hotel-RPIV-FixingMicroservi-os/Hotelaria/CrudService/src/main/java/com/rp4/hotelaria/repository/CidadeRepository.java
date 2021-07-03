package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
     Cidade findCidadeById(Long id);


}
