package br.com.zupacademy.rodrigo.casadocodigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.rodrigo.casadocodigo.form.ClienteForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Estado;
import br.com.zupacademy.rodrigo.casadocodigo.model.Pais;
import br.com.zupacademy.rodrigo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.rodrigo.casadocodigo.repository.PaisRepository;

@Component
public class EstadoEPaisValidator implements Validator {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	PaisRepository paisRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteForm form = (ClienteForm) target;

		Optional<Pais> possivelPais = paisRepository.findById(form.getIdPais());
		Pais pais = possivelPais.get();

		if (form.getIdEstado() != null) {
			Optional<Estado> possivelEstado = estadoRepository.findById(form.getIdEstado());

			Estado estado = possivelEstado.get();

			if (!estado.pertenceAoPais(pais)) {
				errors.rejectValue("idEstado", null, "Este estado (" + form.getIdEstado()
						+ ") não pertence ao país informado (" + form.getIdPais() + ").");
			}
		} else if (pais.temEstados()) {
			errors.rejectValue("idPais", null,
					"Este país (" + form.getIdPais() + ") possui estados, mas nenhum foi informado.");
		}

	}

}
