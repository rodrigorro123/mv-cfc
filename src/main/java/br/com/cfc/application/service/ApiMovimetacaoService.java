package br.com.cfc.application.service;

import br.com.cfc.application.DTO.MovimentacaoDto;
import br.com.cfc.application.DTO.RetornoDto;
import br.com.cfc.application.exception.ApiException;

public interface ApiMovimetacaoService {
	
	RetornoDto  geraMovimetacao(String identificador, MovimentacaoDto movimentacao) throws ApiException;
	
}
