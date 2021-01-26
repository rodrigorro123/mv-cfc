package br.com.cfc.application.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.cfc.application.DTO.MovimentacaoDto;
import br.com.cfc.application.DTO.RetornoDto;
import br.com.cfc.application.exception.ApiException;
import br.com.cfc.application.service.ApiMovimetacaoService;
import br.com.cfc.domain.entity.Cliente;
import br.com.cfc.domain.entity.Movimentacao;
import br.com.cfc.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ApiMovimetacaoServiceImpl implements ApiMovimetacaoService {
	
	private final ClienteRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public RetornoDto geraMovimetacao(String identificador, MovimentacaoDto movimentacao) throws ApiException {
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
			Movimentacao mov =  modelMapper.map( movimentacao , Movimentacao.class);
			
			
			cliente.getMovimentacao().add(mov);
			repository.saveAndFlush(cliente);
			
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
		return null;
		
	}

}