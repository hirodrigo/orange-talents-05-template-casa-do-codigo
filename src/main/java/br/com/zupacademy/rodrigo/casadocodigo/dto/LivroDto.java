package br.com.zupacademy.rodrigo.casadocodigo.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.zupacademy.rodrigo.casadocodigo.model.Livro;

public class LivroDto {
	
	private Long id;
	private String titulo;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public static List<LivroDto> toDtoList(Iterable<Livro> livros) {
		List<LivroDto> livrosDto = new ArrayList<LivroDto>();
		for (Livro livro : livros) {
			livrosDto.add(new LivroDto(livro));
		}
		return livrosDto;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
}
