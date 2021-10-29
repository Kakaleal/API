package org.serratec.java2backend.exercicio02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Date;
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	
	 private Long id;
	@Column(name= " nome", length= 60)
	private String nome;
	
	@Column (name= " cpf", length= 11)
	 private String cpf;
	
	@Column(name= " email", length=50)
	 private String email;
	
	@Column( name= "DataNascimento")
	@Temporal(TemporalType.DATE)
	 private Date DataNascimento;
	
	
 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public static boolean isPresente() {
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean idExistente(Long id2) {
		// TODO Auto-generated method stub
		return false;
	}
 
}
