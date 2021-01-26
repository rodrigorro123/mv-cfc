package br.com.cfc.application.service;

import br.com.cfc.application.DTO.ClienteDto;
import br.com.cfc.application.DTO.RetornoDto;
import br.com.cfc.application.exception.ApiException;

public interface ApiClienteService {
	
	ClienteDto saveCliente(ClienteDto cliente) throws ApiException;
	
	ClienteDto getCliente(String id) throws ApiException;
	
	RetornoDto deleteCliente(String  id) throws ApiException;
	
}
