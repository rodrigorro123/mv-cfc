package br.com.cfc.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cfc.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query( value = " SELECT tc.* \n" + 
					"FROM TB_CLIENTE tc ,\n" + 
					"	 TB_PESSOA_FISICA pf\n" + 
					"WHERE tc.PESSOA_FISICA_ID = pf.ID \n" + 
					"AND pf.CPF  = ? ", 
			nativeQuery = true)
	Optional<Cliente> findByCpf(String cpf);
	
	@Query( value = "SELECT tc.* \n" + 
					"FROM TB_CLIENTE tc ,\n" + 
					"	 TB_PESSOA_JURIDICA pj \n" + 
					"WHERE tc.PESSOA_JURIDICA_ID = pj.ID \n" + 
					"AND pj.CNPJ = ? ", 
	nativeQuery = true)
	Optional<Cliente> findByCnpj(String cnpj);
	
	Optional<Cliente> findByIdentificador(String identificador);
	
	void deleteByIdentificador(String identificador);
	
	
	

}
