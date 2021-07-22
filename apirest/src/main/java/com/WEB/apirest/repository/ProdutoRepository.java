package com.WEB.apirest.repository;

import java.util.Optional;

import com.WEB.apirest.models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
    Optional<Produto> findById(Long id);

}