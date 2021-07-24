package com.WEB.apirest.repository;

import java.util.List;
import java.util.Optional;

import com.WEB.apirest.models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
    Optional<Produto> findById(Long id);
    List<Produto> findByDescricao(String descricao);
}
