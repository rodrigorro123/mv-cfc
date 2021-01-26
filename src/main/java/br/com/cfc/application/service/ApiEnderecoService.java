package br.com.cfc.application.service;

import br.com.cfc.application.DTO.EnderecoDto;
import br.com.cfc.application.DTO.RetornoDto;
import br.com.cfc.application.exception.ApiException;

public interface ApiEnderecoService {
	
	RetornoDto  saveEndereco(String identificador, String tipoEndereco, EnderecoDto endereco) throws ApiException;
	
}
