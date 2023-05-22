package br.com.api.exercicio3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class TohDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="jog_cd_id", nullable=false)
	private Integer id;
	
	@Column(name="jog_tx_nome", nullable=false)
	private String nome;
	
	@Column(name="jog_tx_categorias", nullable=false)
	private String categorias;
	
	@Column(name="jog_tx_personagem", nullable=false)
	private String personagem;

	@Column(name="jog_nm_valor", nullable=false, length=8)
	private Double valor;
	
	@Column(name="jog_bl_status", nullable=false)
	private boolean status;
	
	
	public TohDomain() {
		super();
	}

	public TohDomain(Integer id,String nome,String categorias,String personagem,Double valor,boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.categorias = categorias;
		this.personagem = personagem;
		this.valor = valor;
		this.status = status;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String plataforma) {
		this.personagem = plataforma;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
