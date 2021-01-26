package br.com.cfc.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.cfc.domain.entity.PessoaFisica;

public interface PessoaFisicaRepository extends CrudRepository<PessoaFisica, Long>  {

	Optional<PessoaFisica> findByCpf(String cpf);
	
}
