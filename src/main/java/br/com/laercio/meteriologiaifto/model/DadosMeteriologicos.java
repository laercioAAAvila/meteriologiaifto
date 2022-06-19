package br.com.laercio.meteriologiaifto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "dados_meteriologicos")
public class DadosMeteriologicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "id_estacao")
	private Long idEstacao;
	private double temperatura;
	@Column(name = "umidade_ar")
	private double umidadeDoAr;
	@Column(name = "velocidade_vento")
	private double velocidadeDoVento;
	@Column(name = "direcao_vento")
	private String direcaoDoVento;
	@Column(name = "precipitacao_chuva")
	private double precipitacaoDaChuva;
	@Column(name = "radiacao_solar")
	private double radicaoSolar;
	private String data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEstacao() {
		return idEstacao;
	}

	public void setIdEstacao(Long idEstacao) {
		this.idEstacao = idEstacao;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getUmidadeDoAr() {
		return umidadeDoAr;
	}

	public void setUmidadeDoAr(double umidadeDoAr) {
		this.umidadeDoAr = umidadeDoAr;
	}

	public double getVelocidadeDoVento() {
		return velocidadeDoVento;
	}

	public void setVelocidadeDoVento(double velocidadeDoVento) {
		this.velocidadeDoVento = velocidadeDoVento;
	}

	public String getDirecaoDoVento() {
		return direcaoDoVento;
	}

	public void setDirecaoDoVento(String direcaoDoVento) {
		this.direcaoDoVento = direcaoDoVento;
	}

	public double getPrecipitacaoDaChuva() {
		return precipitacaoDaChuva;
	}

	public void setPrecipitacaoDaChuva(double precipitacaoDaChuva) {
		this.precipitacaoDaChuva = precipitacaoDaChuva;
	}

	public double getRadicaoSolar() {
		return radicaoSolar;
	}

	public void setRadicaoSolar(double radicaoSolar) {
		this.radicaoSolar = radicaoSolar;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
