package br.com.cfc.application.service.impl;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.cfc.application.DTO.EnderecoDto;
import br.com.cfc.application.DTO.RetornoDto;
import br.com.cfc.application.exception.ApiException;
import br.com.cfc.application.service.ApiEnderecoService;
import br.com.cfc.domain.entity.Cliente;
import br.com.cfc.domain.entity.Endereco;
import br.com.cfc.domain.repository.ClienteRepository;
import br.com.cfc.domain.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ApiEnderecoServiceImpl implements ApiEnderecoService {
	
	private final EnderecoRepository endRepository;
	private final ClienteRepository repository;
	private final ModelMapper modelMapper;

	public RetornoDto  saveEndereco(String identificador, String tipoEndereco, EnderecoDto endereco) throws ApiException {
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
			Endereco endAtualizado  = modelMapper.map( endereco , Endereco.class);
			Endereco end   = endRepository.findByTipoEndereco(identificador, tipoEndereco).orElse(null);
			 if(end != null) {
				 endAtualizado.setId(end.getId());
				 endRepository.save(endAtualizado);
			 }
			 else {
				 cliente.setEndereco(Arrays.asList(endAtualizado));
				 repository.save(cliente);
			 }
			 
			RetornoDto retorno = new RetornoDto();
			retorno.setDescricao("Endereco atualizado com sucesso");
			return retorno ;
	 
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