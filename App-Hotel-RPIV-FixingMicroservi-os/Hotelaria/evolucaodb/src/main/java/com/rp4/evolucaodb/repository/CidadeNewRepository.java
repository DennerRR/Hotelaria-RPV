package com.rp4.evolucaodb.repository;

import com.rp4.evolucaodb.model_new.CidadeNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeNewRepository extends JpaRepository<CidadeNew, Long> {
     CidadeNew findCidadeById(Long id);


}
