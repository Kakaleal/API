package org.serratec.java2backend.exercicio02.domain;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Produto {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name= "id_produto")
private long id;

@Column(name  = " descricao", nullable= false, length= 40)
private String descricao;

@Column
private BigDecimal valor;

@Column(name = " DataCadastro")
@Temporal(TemporalType.DATE)
private String DataCadastro;

public Produto() {
	
}
public long getId() {
	return id;
}
public String getDataCadastro() {
	return DataCadastro;
	
}
public String getDescricao() {
	return descricao;
}
public void setId(Long  Id, long id) {
	this.id= id;
	
}
public BigDecimal getValor() {
	return valor;
}
}
