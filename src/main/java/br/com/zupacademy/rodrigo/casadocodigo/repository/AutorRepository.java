package br.com.zupacademy.rodrigo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.rodrigo.casadocodigo.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
	
}
