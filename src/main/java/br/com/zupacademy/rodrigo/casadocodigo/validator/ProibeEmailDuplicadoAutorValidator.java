package br.com.zupacademy.rodrigo.casadocodigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.rodrigo.casadocodigo.form.AutorForm;
import br.com.zupacademy.rodrigo.casadocodigo.model.Autor;
import br.com.zupacademy.rodrigo.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorForm form = (AutorForm) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(form.getEmail());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um(a) outro(a) autor(a) com o mesmo e-mail: " + form.getEmail());
		}

	}

}
