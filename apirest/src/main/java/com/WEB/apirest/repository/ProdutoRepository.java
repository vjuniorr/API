package com.WEB.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WEB.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}