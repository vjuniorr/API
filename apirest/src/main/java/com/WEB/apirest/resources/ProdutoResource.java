package com.WEB.apirest.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.WEB.apirest.repository.ProdutoRepository;



import com.WEB.apirest.models.Produto;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/listprodutos")
	@ApiOperation(value = "Retorna todos os produtos do nosso banco")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}

    @GetMapping("/getproduto/{id}")
	@ApiOperation(value = "Retorna o produto que possui o id passado")
	public Optional<Produto> listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}

    @PostMapping("/postproduto")
	@ApiOperation(value = "Salva um produto no banco")
    public Produto criaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

	@DeleteMapping("/deleteproduto")
	@ApiOperation(value = "Deleta um produto no banco")
	public void removeProduto(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/updateproduto")
	@ApiOperation(value = "Atualiza determinado produto")
	public Produto atualizaProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}

	@GetMapping("/filter")
	@ApiOperation(value = "Retorna todos os produtos que possuem o nome passado")
	public List<Produto> listaProdutosFiltrados(@RequestParam("desc") String desc){
		return this.produtoRepository.findByDescricao(desc).stream().map(p -> p).collect(Collectors.toList());
	}
}