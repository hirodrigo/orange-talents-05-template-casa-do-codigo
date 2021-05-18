package br.com.zupacademy.rodrigo.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.rodrigo.casadocodigo.form.PaisForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Pais;
import br.com.zupacademy.rodrigo.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisForm form) {
		Pais pais = form.toModel();
		paisRepository.save(pais);
		return ResponseEntity.ok().build();
	}

}
