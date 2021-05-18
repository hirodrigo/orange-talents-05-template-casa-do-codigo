package br.com.zupacademy.rodrigo.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.rodrigo.casadocodigo.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
