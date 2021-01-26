package br.com.cfc.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cfc.application.DTO.RelClientesDto;
import br.com.cfc.domain.entity.Movimentacao;


public interface RelatorioRepository extends JpaRepository<Movimentacao, Long>  {
	
 
	@Query(value = "CALL PR_REL_CLIENTE(:identificacao)", nativeQuery = true)
	List<RelClientesDto> findRelClientes(@Param("identificacao") String identificacao);
}
