package br.com.cfc.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.cfc.domain.entity.PessoaJuridica;

public interface PessoaJuridicaRepository extends CrudRepository<PessoaJuridica, Long>  {
	
	Optional<PessoaJuridica> findByCnpj(String cnpj);

	

}
