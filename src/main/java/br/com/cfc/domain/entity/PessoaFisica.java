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
@Table(name = PessoaFisica.TABLE_NAME)
public class PessoaFisica {

	public static final String TABLE_NAME = "tb_pessoa_fisica";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PF_SEQ" )
	@SequenceGenerator(sequenceName = "pf_seq", allocationSize = 1, name = "PF_SEQ")
	 private Long id;
	
	@Column(name = "nome")
	 private String nome;
	
	@Column(name = "telefone")
	 private String telefone;
	
	
	@Column(name = "data_nascimento")
	 private LocalDate dtNascimento;
	
	@Column(name = "cpf")
	 private String cpf;
	
	@Column(name = "email")
	 private String email;
		
}
