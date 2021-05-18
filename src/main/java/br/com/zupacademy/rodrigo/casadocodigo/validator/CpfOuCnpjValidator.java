package br.com.zupacademy.rodrigo.casadocodigo.validator;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.rodrigo.casadocodigo.form.ClienteForm;

@Component
public class CpfOuCnpjValidator implements Validator {

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

		CPFValidator cpfValidator = new CPFValidator();
		CNPJValidator cnpjValidator = new CNPJValidator();
		cpfValidator.initialize(null);
		cnpjValidator.initialize(null);

		if (!cpfValidator.isValid(form.getDocumento(), null) && !cnpjValidator.isValid(form.getDocumento(), null)) {
			errors.rejectValue("documento", null,
					"Este documento (" + form.getDocumento() + ") é inválido, precisa ser CPF ou CNPJ.");
		}
	}

}
