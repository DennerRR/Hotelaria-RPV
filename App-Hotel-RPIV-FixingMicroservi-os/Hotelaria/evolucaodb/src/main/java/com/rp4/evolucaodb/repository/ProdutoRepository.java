package com.rp4.evolucaodb.repository;

import com.rp4.evolucaodb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findProdutoById(Long id);
}
