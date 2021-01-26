package br.com.cfc.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = Conta.TABLE_NAME)
public class Conta implements Serializable {

	private static final long serialVersionUID = -7531824536655287385L;

	public static final String TABLE_NAME = "tb_conta";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTA_SEQ" )
	@SequenceGenerator(sequenceName = "conta_seq", allocationSize = 1, name = "CONTA_SEQ")
	 private Long id;
	
	@Column(name = "banco")
	 private Long banco;
	
	@Column(name = "agencia")
	 private Long agencia;
	
	@Column(name = "nro_conta")
	 private String nroConta;
	
	@Column(name = "principal")
	 private Boolean principal;
	 
}
