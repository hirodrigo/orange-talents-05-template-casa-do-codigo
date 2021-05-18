package br.com.zupacademy.rodrigo.casadocodigo.form;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.rodrigo.casadocodigo.model.Pais;
import br.com.zupacademy.rodrigo.casadocodigo.validator.UniqueValue;

public class PaisForm {
	
	@NotEmpty
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public void setNome(@NotEmpty String nome) {
		this.nome = nome;
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}

}
