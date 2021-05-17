package br.com.zupacademy.rodrigo.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	
	@Deprecated
	public Autor() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nome;

	@Email
	@NotEmpty
	private String email;

	@Size(max = 400)
	private String descricao;

	@NotNull
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	public Autor(@NotEmpty String nome, @Email @NotEmpty String email, @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

}
