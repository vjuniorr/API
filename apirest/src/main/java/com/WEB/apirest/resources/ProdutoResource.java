package com.WEB.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WEB.apirest.repository.ProdutoRepository;



import com.WEB.apirest.models.Produto;


@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	
}