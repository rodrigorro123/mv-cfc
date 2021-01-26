package br.com.cfc.application.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.cfc.application.DTO.RelClientesDto;
import br.com.cfc.application.exception.ApiException;
import br.com.cfc.application.service.ApiRelatorioService;
import br.com.cfc.domain.entity.Cliente;
import br.com.cfc.domain.repository.ClienteRepository;
import br.com.cfc.domain.repository.RelatorioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ApiRelatorioServiceImpl implements ApiRelatorioService {
	
	private final ClienteRepository repository;
	private final RelatorioRepository relRepository;

	@Override
	public List<RelClientesDto> getRelatorioCliente(String identificador) throws ApiException {
		try {

			Cliente cliente = repository.findByIdentificador(identificador).orElse(null);
			
			if(cliente == null) {
	            throw ApiException
	            .builder()
	            .statusCode(HttpStatus.BAD_REQUEST.value())
	            .code(ApiException.VALIDATION_ERROR)
	            .message("Cliente nao identificado")
	            .reason("Cliente nao identificado")
	            .build();	
			}
			
			return relRepository.findRelClientes(identificador);
			
		} catch(ApiException ae) {
            throw ApiException
            .builder()
            .statusCode(ae.getStatusCode())
            .code(ae.getCode())
            .message(ae.getMessage())
            .reason(ae.getReason())
            .build();
		} catch (Exception e) {
			log.error(e.getMessage());
            throw ApiException
            .builder()
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .code(ApiException.GENERAL_ERROR)
            .message("Erro ao buscar dados")
            .reason("Erro ao buscar dados")
            .build();
		}
	}

}