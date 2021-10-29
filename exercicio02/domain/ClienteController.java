package org.serratec.java2backend.exercicio02.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.exercicio02.domain.ClienteRepository;
@SuppressWarnings("unused")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	 @Autowired
	private  ClienteRepository clienteRepository;
	 @GetMapping
	  public ResponseEntity<List<Cliente>>ListarClientes(){
	   return ResponseEntity.ok(clienteRepository.findAll());
			 
	 }
	 @GetMapping("/id")
	 public ResponseEntity<Optional<Cliente>> pesquisarUm(@PathVariable  long id){
		 return ResponseEntity.ok(clienteRepository.findById(id));
		 if(Cliente.isPresente()) {
			 return ResponseEntity.ok(Cliente.get());
		 }
	     return ResponseEntity.notFound().build();
}
	 @PostMapping
	 public  ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
		 return  ResponseEntity.status(HttpStatus.CREATED).body(cliente);

	 }
 
	@PutMapping
	public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente,@PathVariable Long id){
       if(Cliente.idExistente(id)) {
    	   return ResponseEntity.notFound().build();
       }
	return null; 
    
   

	cliente.setId(id);
	cliente= clienteRepository.save(cliente);
     return ResponseEntity.ok(cliente);
}
	
}
