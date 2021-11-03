package org.serratec.java2backend.exercicio02.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.java2backend.exercicio02.domain.Produto;
import org.serratec.java2backend.exercicio02.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> pesquisarTodos() {
		List<Produto> listaProdutos = produtoService.pesquisarTodos();
		return ResponseEntity.ok(listaProdutos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> pesquisarUm(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.pesquisarUm(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto produto) {//, UriComponentsBuilder b) {
		//UriComponents uriComponents = b.path("/produtos/{id}").buildAndExpand(produto.getId());
		//return ResponseEntity.created(uriComponents.toUri()).body(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.inserir(produto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produto, @PathVariable Long id) {
		if (!produtoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoService.inserir(produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!produtoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
}
