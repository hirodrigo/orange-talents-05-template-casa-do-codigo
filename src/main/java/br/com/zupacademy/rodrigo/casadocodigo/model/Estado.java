package br.com.zupacademy.rodrigo.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nome;
	
	@ManyToOne
	@NotNull
	private Pais pais;
	
	@Deprecated
	public Estado() {
	}
	
	public Estado(@NotEmpty String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

}
