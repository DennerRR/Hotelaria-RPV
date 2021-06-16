package com.rp4.consumoservice.repository;

import com.rp4.consumoservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findProdutoById(Long id);
}
