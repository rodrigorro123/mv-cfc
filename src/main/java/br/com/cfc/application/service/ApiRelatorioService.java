package br.com.cfc.application.service;

import java.util.List;

import br.com.cfc.application.DTO.RelClientesDto;
import br.com.cfc.application.exception.ApiException;

public interface ApiRelatorioService {
	
	List<RelClientesDto>  getRelatorioCliente(String identificador) throws ApiException;
	
}
