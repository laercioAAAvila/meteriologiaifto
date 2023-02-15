package br.com.laercio.meteriologiaifto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estacao_meteriologica")
public class EstacaoMeteriologica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	@Column(name = "posicao_no_mapa")
	private String posicaoMapa;

	@OneToMany(mappedBy = "estacaoMeteriologica", cascade = CascadeType.ALL)
	private List<DadosMeteriologicos> dadosMeteriologicos = new ArrayList<DadosMeteriologicos>();

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

	public String getPosicaoMapa() {
		return posicaoMapa;
	}

	public void setPosicaoMapa(String posicaoMapa) {
		this.posicaoMapa = posicaoMapa;
	}

	public List<DadosMeteriologicos> getDadosMeteriologicos() {
		return dadosMeteriologicos;
	}

	public void addDadosMeteriologicos(DadosMeteriologicos dadosMeteriologicos) {
		dadosMeteriologicos.setEstacaoMeteriologica(this);
		this.dadosMeteriologicos.add(dadosMeteriologicos);
	}

}
