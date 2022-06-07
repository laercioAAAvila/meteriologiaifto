package br.com.laercio.meteriologiaifto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "estacao_meteriologica")
public class EstacaoMeteriologica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	@Column(name = "posicao_mapa")
	private String posicaoNoMapa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPosicaoNoMapa() {
		return posicaoNoMapa;
	}

	public void setPosicaoNoMapa(String posicaoNoMapa) {
		this.posicaoNoMapa = posicaoNoMapa;
	}

}
