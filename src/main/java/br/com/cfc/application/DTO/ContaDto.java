package br.com.cfc.application.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContaDto implements Serializable {

	private static final long serialVersionUID = -7531824536655287385L;

	 private Long id;
	
	 private Long banco;
	
	 private Long agencia;
	
	 private String nroConta;
	
	 private Boolean principal;
	 		
}
