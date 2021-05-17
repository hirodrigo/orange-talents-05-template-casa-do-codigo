package br.com.zupacademy.rodrigo.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.rodrigo.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Categoria;
import br.com.zupacademy.rodrigo.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.rodrigo.casadocodigo.validator.ProibeNomeDuplicadoCategoriaValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.toModel();
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
	}

}
