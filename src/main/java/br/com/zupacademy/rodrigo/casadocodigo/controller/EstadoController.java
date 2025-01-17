package br.com.zupacademy.rodrigo.casadocodigo.controller;

import javax.persistence.EntityManager;
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

import br.com.zupacademy.rodrigo.casadocodigo.form.EstadoForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Estado;
import br.com.zupacademy.rodrigo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.rodrigo.casadocodigo.validator.EstadoEPaisValidator;
import br.com.zupacademy.rodrigo.casadocodigo.validator.EstadoUnicoNoPaisValidator;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private EstadoUnicoNoPaisValidator estadoUnicoNoPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoUnicoNoPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.toModel(entityManager);
		estadoRepository.save(estado);
		return ResponseEntity.ok().build();
	}

}
