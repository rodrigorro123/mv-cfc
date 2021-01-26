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
@Entity(name= "TbPessoaJuridica")
@Table(name = PessoaJuridica.TABLE_NAME)
public class PessoaJuridica {

	public static final String TABLE_NAME = "tb_pessoa_juridica";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PJ_SEQ" )
	@SequenceGenerator(sequenceName = "pj_seq", allocationSize = 1, name = "PJ_SEQ")
	 private Long id;
	
	@Column(name = "nome")
	 private String nome;
	
	@Column(name = "telefone")
	 private String telefone;
	
	@Column(name = "data_nascimento")
	 private LocalDate dtNascimento;
	
	@Column(name = "cnpj")
	 private String cnpj;
	
	@Column(name = "inscricao_estadual")
	 private String ie;
	
	@Column(name = "email")
	 private String email;
	
}
