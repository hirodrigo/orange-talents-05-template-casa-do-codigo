package br.com.zupacademy.rodrigo.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.zupacademy.rodrigo.casadocodigo.model.Autor;

public class AutorForm {

	@NotEmpty
	private String nome;
	
	@Email
	@NotEmpty
	private String email;
	
	@Size(max = 400)
	private String descricao;

	public AutorForm(@NotEmpty String nome, @Email @NotEmpty String email, @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
