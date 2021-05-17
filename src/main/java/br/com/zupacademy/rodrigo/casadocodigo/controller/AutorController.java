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

import br.com.zupacademy.rodrigo.casadocodigo.form.AutorForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Autor;
import br.com.zupacademy.rodrigo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.rodrigo.casadocodigo.validator.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorForm form) {
		Autor autor = form.toModel();
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}

}
