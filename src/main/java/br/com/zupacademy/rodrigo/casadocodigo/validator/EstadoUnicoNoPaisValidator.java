package br.com.zupacademy.rodrigo.casadocodigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.rodrigo.casadocodigo.form.EstadoForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Estado;
import br.com.zupacademy.rodrigo.casadocodigo.repository.EstadoRepository;

@Component
public class EstadoUnicoNoPaisValidator implements Validator {

	@Autowired
	EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		EstadoForm form = (EstadoForm) target;
		Optional<Estado> estado = estadoRepository.findByNomeAndPaisId(form.getNome(), form.getIdPais());

		if (estado.isPresent()) {
			errors.rejectValue("nome", null, "Já existe um estado com esse nome (" + form.getNome()
					+ ") no país com id (" + form.getIdPais() + ").");
		}

	}

}
