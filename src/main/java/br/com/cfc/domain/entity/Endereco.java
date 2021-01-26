package br.com.cfc.domain.entity;

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
@Table(name = Endereco.TABLE_NAME)
public class Endereco {

	public static final String TABLE_NAME = "tb_endereco";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "END_SEQ" )
	@SequenceGenerator(sequenceName = "endereco_seq", allocationSize = 1, name = "END_SEQ")
	 private Long id;
	
	@Column(name = "tipo_endereco")
	 private String tipoEndereco;
	
	@Column(name = "rua")
	 private String rua;
	
	@Column(name = "bairro")
	 private String bairro;

	@Column(name = "numero")
	 private String numero;
	
	@Column(name = "complemento")
	 private String complemento;
	
	@Column(name = "cidade")
	 private String cidade;
	
	@Column(name = "uf")
	 private String uf;

	@Column(name = "cep")
	 private String cep;
	 
}
