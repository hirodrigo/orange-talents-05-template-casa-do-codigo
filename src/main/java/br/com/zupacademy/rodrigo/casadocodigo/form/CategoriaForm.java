package br.com.zupacademy.rodrigo.casadocodigo.form;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.rodrigo.casadocodigo.model.Categoria;

public class CategoriaForm {

	@NotEmpty
	private String nome;
		
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

}
