package br.com.cfc.domain.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {

	public static final String TABLE_NAME = "tb_cliente";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "CLIENTE_SEQ" )
	@SequenceGenerator(sequenceName = "cliente_seq", allocationSize = 1, name = "CLIENTE_SEQ")
	 private Long id;
	
	@Column(name = "identificador")
	private String identificador;
	
	@Column(name = "tipo_cliente")
	private Long tipoCliente;

	@Column(name = "dat_cadastro")
	private LocalDate dtCadastro;
	
	@Column(name = "ativo")
	 private Boolean ativo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pessoa_fisica_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PessoaFisica pessoaFisicas;	
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pessoa_juridica_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PessoaJuridica pessoaJuridicas;	
 	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
	private List<Conta> conta ;

	
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "cliente_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
	private List<Endereco> endereco ;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")	
    @OnDelete(action = OnDeleteAction.NO_ACTION)
	private List<Movimentacao> movimentacao ;
	
	
}
