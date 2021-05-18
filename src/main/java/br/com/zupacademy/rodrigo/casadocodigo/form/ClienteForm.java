package br.com.zupacademy.rodrigo.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.rodrigo.casadocodigo.model.Cliente;
import br.com.zupacademy.rodrigo.casadocodigo.model.Estado;
import br.com.zupacademy.rodrigo.casadocodigo.model.Pais;
import br.com.zupacademy.rodrigo.casadocodigo.validator.ExistsId;
import br.com.zupacademy.rodrigo.casadocodigo.validator.UniqueValue;

public class ClienteForm {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	
	
	
	public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, @NotNull Long idPais,
			Long idEstado) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}
	
	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getDocumento() {
		return documento;
	}

	public Cliente toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, idPais);
		Assert.state(pais != null, "Um país que não existe no banco está tentando sendo atrelado ao cliente: " + idPais);
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
		
		if (idEstado != null) {
			Estado estado = entityManager.find(Estado.class, idEstado);
			Assert.state(estado != null, "Uma estado que não existe no banco está tentando sendo atrelada ao cliente: " + idEstado);
			cliente.setEstado(estado);
		}

		return cliente;
	}
	
}
