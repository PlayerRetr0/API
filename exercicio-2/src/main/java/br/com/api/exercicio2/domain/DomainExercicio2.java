package br.com.api.exercicio2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jogo")
public class DomainExercicio2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="jog_cd_id", nullable=false)
	private Integer id;
	
	@Column(name="jog_tx_nome", nullable=false)
	private String nome;
	
	@Column(name="jog_tx_categorias", nullable=false)
	private String categorias;
	
	@Column(name="jog_tx_plataforma", nullable=false)
	private String plataforma;

	@Column(name="jog_nm_valor", nullable=false, length=8)
	private Double valor;
	
	@Column(name="jog_bl_status", nullable=false)
	private boolean status;
	
	
	public DomainExercicio2() {
		super();
	}

	public DomainExercicio2(Integer id,String nome,String categorias,String plataforma,Double valor,boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.categorias = categorias;
		this.plataforma = plataforma;
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

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
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
