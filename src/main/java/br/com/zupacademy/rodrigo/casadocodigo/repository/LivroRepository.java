package br.com.zupacademy.rodrigo.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.rodrigo.casadocodigo.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}
