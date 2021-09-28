package com.rp4.evolucaodb.repository;

import com.rp4.evolucaodb.model_new.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
     Cidade findCidadeById(Long id);


}
