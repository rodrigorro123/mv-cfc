package br.com.cfc.application.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Valid
@Data
public class ClienteDto  {
 
	private Long id;
	
	private String identificador;
	
	private Long tipoCliente;

	private LocalDate dtCadastro = LocalDate.now();
	
	private Boolean ativo = true;
	
	private PessoaFisicaDto pessoaFisicas;	
	  
	private PessoaJuridicaDto pessoaJuridicas;	
 	
	private List<ContaDto> conta ;

	@NotNull
	private List<MovimentacaoDto> movimentacao ;
	
	@NotNull
	private List<EnderecoDto> endereco;	
}
