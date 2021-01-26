package br.com.cfc.application.DTO;

import lombok.Data;


@Data
public class EnderecoDto {

	 private Long id;
	
	 private String tipoEndereco;
	
	 private String rua;
	
	 private String bairro;

	 private String numero;
	
	 private String complemento;
	
	 private String cidade;
	
	 private String uf;

	 private String cep;
	 
	 private EnderecoDto endereco;
	
}
