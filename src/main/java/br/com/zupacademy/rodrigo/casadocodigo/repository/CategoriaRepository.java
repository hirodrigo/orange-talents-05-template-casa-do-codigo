package br.com.zupacademy.rodrigo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.rodrigo.casadocodigo.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	Optional<Categoria> findByNome(String nome);
	
}
