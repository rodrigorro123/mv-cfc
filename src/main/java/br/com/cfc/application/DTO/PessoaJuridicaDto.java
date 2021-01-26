package br.com.cfc.application.DTO;

import java.time.LocalDate;

import lombok.Data;


@Data
public class PessoaJuridicaDto {

	public static final String TABLE_NAME = "tb_pessoa_juridica";
	
	 private Long id;
	
	 private String nome;
	
	 private String telefone;
	
	 private LocalDate dtNascimento;
	
	 private String cnpj;
	
	 private String ie;
	
	 private String email;
		
}
