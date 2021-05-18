package br.com.zupacademy.rodrigo.casadocodigo.dto;

import br.com.zupacademy.rodrigo.casadocodigo.model.Autor;

public class LivroDetalheAutorDto {
	
	private String nome;
	private String descricao;
	
	public LivroDetalheAutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
