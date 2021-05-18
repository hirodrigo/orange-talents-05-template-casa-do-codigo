package br.com.zupacademy.rodrigo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.rodrigo.casadocodigo.model.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

	Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);
	
}
