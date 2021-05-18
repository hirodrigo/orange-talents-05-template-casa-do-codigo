package br.com.zupacademy.rodrigo.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pais {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nome;

	@Deprecated
	public Pais() {
	}
	
	public Pais(@NotEmpty String nome) {
		this.nome = nome;
	}
	
}
