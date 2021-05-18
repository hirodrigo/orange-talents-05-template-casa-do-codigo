package br.com.zupacademy.rodrigo.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.rodrigo.casadocodigo.model.Livro;

public class LivroDetalheDto {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer nPaginas;
	private String isbn;
	private String dataPublicacao;
	private LivroDetalheAutorDto autor;
	
	public LivroDetalheDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.nPaginas = livro.getnPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new LivroDetalheAutorDto(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getnPaginas() {
		return nPaginas;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public LivroDetalheAutorDto getAutor() {
		return autor;
	}
	
}
