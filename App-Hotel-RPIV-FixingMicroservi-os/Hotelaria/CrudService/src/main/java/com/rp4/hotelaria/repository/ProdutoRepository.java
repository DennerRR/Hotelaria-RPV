package com.rp4.hotelaria.repository;

import com.rp4.hotelaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findProdutoById(Long id);
}
