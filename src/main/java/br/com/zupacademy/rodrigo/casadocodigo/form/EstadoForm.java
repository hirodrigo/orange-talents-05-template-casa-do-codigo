package br.com.zupacademy.rodrigo.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.rodrigo.casadocodigo.model.Estado;
import br.com.zupacademy.rodrigo.casadocodigo.model.Pais;
import br.com.zupacademy.rodrigo.casadocodigo.validator.ExistsId;
import br.com.zupacademy.rodrigo.casadocodigo.validator.UniqueValue;

public class EstadoForm {
	
	@NotEmpty
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public EstadoForm(@NotEmpty String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, idPais);
		Assert.state(pais != null, "Um estado está sendo atrelado a um país que não existe no banco de dados: " + idPais);
		return new Estado(this.nome, pais);
	}

}
