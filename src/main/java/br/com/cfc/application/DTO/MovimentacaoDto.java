package br.com.cfc.application.DTO;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Valid
@Data
public class MovimentacaoDto {

	 private Long id;
	
	 @NotNull
	 private Long valor;
	
	 private LocalDate dataMovimentacao = LocalDate.now() ;
	
	 @NotNull
	 private String tipoMovimentacao;
	
	
}
