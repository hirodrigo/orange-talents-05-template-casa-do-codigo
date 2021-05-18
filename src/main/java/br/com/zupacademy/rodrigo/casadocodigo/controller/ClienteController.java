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

import br.com.zupacademy.rodrigo.casadocodigo.form.ClienteForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Cliente;
import br.com.zupacademy.rodrigo.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.rodrigo.casadocodigo.validator.CpfOuCnpjValidator;
import br.com.zupacademy.rodrigo.casadocodigo.validator.EstadoEPaisValidator;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CpfOuCnpjValidator cpfOuCnpjValidator;
	
	@Autowired
	private EstadoEPaisValidator estadoEPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(cpfOuCnpjValidator, estadoEPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteForm form) {
		Cliente cliente = form.toModel(entityManager);
		clienteRepository.save(cliente);
		return ResponseEntity.ok().build();
	}

}
