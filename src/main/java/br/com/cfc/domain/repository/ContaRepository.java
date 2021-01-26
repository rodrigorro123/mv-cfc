package br.com.cfc.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cfc.domain.entity.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long>  
{

}
