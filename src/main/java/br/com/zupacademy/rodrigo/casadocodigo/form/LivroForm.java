package br.com.zupacademy.rodrigo.casadocodigo.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.rodrigo.casadocodigo.model.Autor;
import br.com.zupacademy.rodrigo.casadocodigo.model.Categoria;
import br.com.zupacademy.rodrigo.casadocodigo.model.Livro;
import br.com.zupacademy.rodrigo.casadocodigo.validator.ExistsId;
import br.com.zupacademy.rodrigo.casadocodigo.validator.UniqueValue;

public class LivroForm {
	
	@NotEmpty
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotNull
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer nPaginas;
	
	@NotEmpty
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;
	
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	
	public LivroForm(@NotEmpty String titulo, @NotNull @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer nPaginas, @NotEmpty String isbn,
			@NotNull Long idAutor, @NotNull Long idCategoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.nPaginas = nPaginas;
		this.isbn = isbn;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	public void setDataPublicacao(@NotNull @Future LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager entityManager) {
		Autor autor = entityManager.find(Autor.class, idAutor);
		Categoria categoria = entityManager.find(Categoria.class, idCategoria);
		
		Assert.state(autor != null, "Um autor que não existe no banco está tentando sendo atrelado ao livro: " + idAutor);
		Assert.state(categoria != null, "Uma categoria que não existe no banco está tentando sendo atrelada ao livro: " + idCategoria);
		
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.nPaginas, this.isbn, this.dataPublicacao, autor, categoria);
	}

}
