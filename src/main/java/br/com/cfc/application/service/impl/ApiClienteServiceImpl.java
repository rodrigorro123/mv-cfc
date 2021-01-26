package br.com.cfc.application.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import br.com.cfc.application.DTO.ClienteDto;
import br.com.cfc.application.DTO.RetornoDto;
import br.com.cfc.application.exception.ApiException;
import br.com.cfc.application.service.ApiClienteService;
import br.com.cfc.domain.entity.Cliente;
import br.com.cfc.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ApiClienteServiceImpl implements ApiClienteService {
	
	private final ClienteRepository repository;
	private final ModelMapper modelMapper;

	public ClienteDto saveCliente(ClienteDto cliente) throws ApiException {
		try {

			Cliente client = new Cliente();
			String uniqueID = "";
			
			if(!Strings.isNullOrEmpty( cliente.getIdentificador())) {
				client = repository.findByIdentificador(cliente.getIdentificador()).orElse(null);
				if(client != null) {
					uniqueID = client.getIdentificador();
					repository.deleteByIdentificador(uniqueID);
				}else {
					uniqueID = UUID.randomUUID().toString();
				}
			}else {
				uniqueID = UUID.randomUUID().toString();
			}
			
			client = modelMapper.map(cliente, Cliente.class);
			client.setIdentificador(uniqueID);

			return  modelMapper.map(repository.saveAndFlush( client) , ClienteDto.class);
		
		} catch (Exception e) {
			log.error(e.getMessage());
            throw ApiException
            .builder()
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .code(ApiException.GENERAL_ERROR)
            .message("Erro ao salvar dados")
            .reason("Erro ao salvar dados")
            .build();
		}
	}
	
	public ClienteDto getCliente(String id) throws ApiException{
		try {
			
			Cliente cliente = repository.findByIdentificador(id).orElse(null);
			
			if(cliente == null) {
	            throw ApiException
	            .builder()
	            .statusCode(HttpStatus.NOT_FOUND.value())
	            .code(ApiException.NOTFOUND_ERROR)
	            .message("Dados nao encontrado")
	            .reason("Cliente nao encontrado")
	            .build();
			}
			return modelMapper.map( cliente , ClienteDto.class);
			
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

	public RetornoDto deleteCliente(String id) throws ApiException{
		try {
			
			Cliente cliente = repository.findByIdentificador(id).orElse(null);
			
			if(cliente == null) {
	            throw ApiException
	            .builder()
	            .statusCode(HttpStatus.NOT_FOUND.value())
	            .code(ApiException.NOTFOUND_ERROR)
	            .message("Dado nao encontrado")
	            .reason("Cliente nao encontrado")
	            .build();
			}
			
			cliente.setAtivo(false);			
			repository.saveAndFlush(cliente);
			
			RetornoDto retorno = new RetornoDto();
			retorno.setDescricao("Cliente Apagado com sucesso");
			
			return  retorno;
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