package br.com.cfc.application.controller;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cfc.application.DTO.ClienteDto;
import br.com.cfc.application.DTO.EnderecoDto;
import br.com.cfc.application.DTO.Error;
import br.com.cfc.application.DTO.MovimentacaoDto;
import br.com.cfc.application.exception.ApiException;
import br.com.cfc.application.service.ApiClienteService;
import br.com.cfc.application.service.ApiEnderecoService;
import br.com.cfc.application.service.ApiMovimetacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Listar Ferramentas")
@CrossOrigin
@Slf4j
@RequestMapping("/cfc")
@RequiredArgsConstructor
@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Api executada com sucesso"),
		@ApiResponse(code = 201, message = "Registro criado com sucesso"),
		@ApiResponse(code = 204, message = "Registro apagado com sucesso"),
		@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
	    @ApiResponse(code = 403, message = "É proibido acessar o recurso que você estava tentando acessar"),
	    @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
public class ApiController {

	private final ApiClienteService clienteService;
	private final ApiEnderecoService endService;
	private final ApiMovimetacaoService movService;

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/cliente")
	@ApiOperation(value = "Metodo para Criar cliente")
	@Produces(value=MediaType.APPLICATION_JSON)
	public ResponseEntity<?> createClient(@Valid @RequestBody ClienteDto cliente) throws ApiException {

		
			try {
				return ResponseEntity.ok(clienteService.saveCliente(cliente));
				
	        } catch (ApiException ex) 
			{
	        	log.error(ex.getMessage());
	            return ResponseEntity.status(ex.getStatusCode()).body(Error.builder()
                        .code(ex.getStatusCode().toString())
                        .message(ex.getCode())
                        .description(ex.getMessage())
                        .build());
	        }
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping("/cliente")
	@ApiOperation(value = "Metodo para Atualizar cliente")
	@Produces(value=MediaType.APPLICATION_JSON)
	public ResponseEntity<?> updateClient(@Valid @RequestBody ClienteDto cliente) throws ApiException {

		
			try {
				return ResponseEntity.ok(clienteService.saveCliente(cliente));
				
	        } catch (ApiException ex) 
			{
	        	log.error(ex.getMessage());
	            return ResponseEntity.status(ex.getStatusCode()).body(Error.builder()
                        .code(ex.getStatusCode().toString())
                        .message(ex.getCode())
                        .description(ex.getMessage())
                        .build());
	        }
	}
	
	/**
	 * metodo para apagar registro no banco
	 * @param identificador
	 * @return
	 */
	@DeleteMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "metodo para apagar registro no banco")
	@Produces(value=MediaType.APPLICATION_JSON)
	public ResponseEntity<?> apagar(@PathVariable String identificador) {
		
		try {
			
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(clienteService.deleteCliente(identificador)) ;
			
	    } 
		catch (ApiException ex) {
			log.error(ex.getMessage());
            return ResponseEntity.status(ex.getStatusCode()).body(Error.builder()
                    .code(ex.getStatusCode().toString())
                    .message(ex.getCode())
                    .description(ex.getMessage())
                    .build());
	    }
	}

	@ResponseStatus(HttpStatus.OK)
	@PatchMapping("/endereco")
	@ApiOperation(value = "Metodo para Atualizar Endereco")
	@Produces(value=MediaType.APPLICATION_JSON)
	public ResponseEntity<?> updateEndereco( @Valid @RequestBody EnderecoDto  endereco,
										  @RequestParam(required = true, name = "identificador") String identificador,
										  @RequestParam(required = true, name = "tipoEndereco") String tipoEndereco
			) throws ApiException {

		
			try {
				return ResponseEntity.ok(endService.saveEndereco(identificador, tipoEndereco, endereco) );
				
	        } catch (ApiException ex) 
			{
	        	log.error(ex.getMessage());
	            return ResponseEntity.status(ex.getStatusCode()).body(Error.builder()
                        .code(ex.getStatusCode().toString())
                        .message(ex.getCode())
                        .description(ex.getMessage())
                        .build());
	        }
	}	

	
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping("/movimentacao")
	@ApiOperation(value = "Metodo para criar movimentacao")
	@Produces(value=MediaType.APPLICATION_JSON)
	public ResponseEntity<?> updateMovimentacao( @Valid @RequestBody MovimentacaoDto  movimentacao,
										  @RequestParam(required = true, name = "identificador") String identificador 
			) throws ApiException {

		
			try {
				return ResponseEntity.ok( movService.geraMovimetacao(identificador, movimentacao)  );
				
	        } catch (ApiException ex) 
			{
	        	log.error(ex.getMessage());
	            return ResponseEntity.status(ex.getStatusCode()).body(Error.builder()
                        .code(ex.getStatusCode().toString())
                        .message(ex.getCode())
                        .description(ex.getMessage())
                        .build());
	        }
	}		
}
