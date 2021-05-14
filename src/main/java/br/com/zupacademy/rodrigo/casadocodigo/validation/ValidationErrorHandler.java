package br.com.zupacademy.rodrigo.casadocodigo.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zupacademy.rodrigo.casadocodigo.dto.ValidationErrorDto;


@RestControllerAdvice
public class ValidationErrorHandler {
		
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ValidationErrorDto> handleValidationError(MethodArgumentNotValidException exception) {
		List<ValidationErrorDto> dtoList = new ArrayList<ValidationErrorDto>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ValidationErrorDto error = new ValidationErrorDto(e.getField(), mensagem);
			dtoList.add(error);
		});
		
		return dtoList;
	}

}
