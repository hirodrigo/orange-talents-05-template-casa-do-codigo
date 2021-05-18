package br.com.zupacademy.rodrigo.casadocodigo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pais {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nome;
	
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;
	

	@Deprecated
	public Pais() {
	}
	
	public Pais(@NotEmpty String nome) {
		this.nome = nome;
	}
	
	public boolean temEstados() {
		return (estados.size() >= 1);
	}
	
}
