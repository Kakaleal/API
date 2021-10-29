package org.serratec.java2backend.exercicio02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.serratec.java2backend.exercicio02.*;
import org.serratec.java2backend.exercicio02.domain.Produto;
@RestController
@RequestMapping("/peodutos")
public class ProndutoController {
  @Autowired
  private ProdutoRepository;
  @GetMapping
  public list<Produto>Listar(){
	  try {
		return ProdutoRepository.findAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
