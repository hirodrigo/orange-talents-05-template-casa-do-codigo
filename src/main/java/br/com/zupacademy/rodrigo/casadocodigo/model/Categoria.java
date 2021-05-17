package br.com.zupacademy.rodrigo.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Categoria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nome;
	
	@Deprecated
	public Categoria() {
	}
	
	public Categoria(@NotEmpty String nome) {
		this.nome = nome;
	}

}
