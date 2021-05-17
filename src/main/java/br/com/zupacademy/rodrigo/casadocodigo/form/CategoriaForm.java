package br.com.zupacademy.rodrigo.casadocodigo.form;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.rodrigo.casadocodigo.model.Categoria;
import br.com.zupacademy.rodrigo.casadocodigo.validator.UniqueValue;

public class CategoriaForm {

	@NotEmpty
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
