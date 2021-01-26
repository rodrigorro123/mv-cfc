package br.com.cfc.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.cfc.domain.entity.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long>  {
	
	@Query( value = "SELECT te.* \n" + 
			"FROM TB_CLIENTE tc ,\n" + 
			"	 TB_ENDERECO te\n" + 
			"WHERE tc.ID = 1\n" + 
			"AND   Tc.ID  = te.cliente_id \n" + 
			"AND   tc.identificador = ?\n" + 
			"AND   te.TIPO_ENDERECO = ? " ,
			nativeQuery =  true)
	Optional<Endereco> findByTipoEndereco(String idCliente, String tipoEndereco);

}
