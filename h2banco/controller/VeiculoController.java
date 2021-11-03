package org.serratec.backend.h2banco.controller;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Veiculo;
import org.serratec.backend.h2banco.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@PostMapping
	public ResponseEntity<Veiculo> inserir(@Valid @RequestBody Veiculo veiculo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoRepository.save(veiculo));
	}
}
