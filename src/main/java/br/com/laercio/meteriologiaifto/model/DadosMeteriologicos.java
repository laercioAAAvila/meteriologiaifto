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
	private double umidadeAr;
	@Column(name = "velocidade_vento")
	private double velocidadeVento;
	@Column(name = "direcao_vento")
	private String direcaoVento;
	@Column(name = "precipitacao_chuva")
	private double precipitacaoChuva;
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

	public double getUmidadeAr() {
		return umidadeAr;
	}

	public void setUmidadeAr(double umidadeAr) {
		this.umidadeAr = umidadeAr;
	}

	public double getVelocidadeVento() {
		return velocidadeVento;
	}

	public void setVelocidadeVento(double velocidadeVento) {
		this.velocidadeVento = velocidadeVento;
	}

	public String getDirecaoVento() {
		return direcaoVento;
	}

	public void setDirecaoVento(String direcaoVento) {
		this.direcaoVento = direcaoVento;
	}

	public double getPrecipitacaoChuva() {
		return precipitacaoChuva;
	}

	public void setPrecipitacaoChuva(double precipitacaoChuva) {
		this.precipitacaoChuva = precipitacaoChuva;
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
