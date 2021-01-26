package br.com.cfc.application.DTO;

import java.time.LocalDate;

import lombok.Data;


@Data
public class PessoaFisicaDto {

	public static final String TABLE_NAME = "tb_pessoa_fisica";
	
	 private Long id;
	
	 private String nome;
	
	 private String telefone;
	
	 private LocalDate dtNascimento;
	
	 private String cpf;
	
	 private String email;
	
}
