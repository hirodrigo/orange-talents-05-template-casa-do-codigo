package br.com.zupacademy.rodrigo.casadocodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.rodrigo.casadocodigo.dto.LivroDto;
import br.com.zupacademy.rodrigo.casadocodigo.form.LivroForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Livro;
import br.com.zupacademy.rodrigo.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm form) {
		Livro livro = form.toModel(entityManager);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<LivroDto> listar(){
		Iterable<Livro> livros = livroRepository.findAll();
		return LivroDto.toDtoList(livros);
	}

}
