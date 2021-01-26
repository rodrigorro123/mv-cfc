package br.com.cfc.application.DTO;

import java.time.LocalDate;

import lombok.Data;


@Data
public class RelClientesDto {

	 private LocalDate datCadastro;
	 private String tipoMovimentacao;
	 private Long qtde;
	 private Long total;
	 private Long valor;
	
	 private String tipoEndereco;
	
	 private String rua;
	
	 private String bairro;

	 private String numero;
	
	 private String complemento;
	
	 private String cidade;
	
	 private String uf;

	 private String cep;
	 
	 private RelClientesDto endereco;
	
}
