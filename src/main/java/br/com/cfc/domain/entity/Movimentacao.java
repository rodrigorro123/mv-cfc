package br.com.cfc.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = Movimentacao.TABLE_NAME)
public class Movimentacao  {

	public static final String TABLE_NAME = "tb_movimentacao";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIMENTACAO_SEQ" )
	@SequenceGenerator(sequenceName = "movimentacao_seq", allocationSize = 1, name = "MOVIMENTACAO_SEQ")
	 private Long id;
	
	@Column(name = "valor")
	 private Double valor;
	
	@Column(name = "data_movimentacao")
	 private LocalDate dataMovimentacao;
	
	@Column(name = "tipo_movimentacao")
	 private String tipoMovimentacao;
 
}
