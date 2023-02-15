package br.com.laercio.meteriologiaifto.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dados_meteriologicos")
public class DadosMeteriologicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double temperatura;
	@Column(name = "umidade_do_ar")
	private double umidadeAr;
	@Column(name = "velocidade_do_vento")
	private double velocidadeVento;
	@Column(name = "direcao_do_vento")
	private String direcaoVento;
	@Column(name = "precipitacao_da_chuva")
	private double precipitacaoChuva;
	@Column(name = "radiacao_do_solar")
	private double radicaoSolar;
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "estacao_id")
	private EstacaoMeteriologica estacaoMeteriologica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDataBr() {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String br = this.data.format(formatters);
		return br;
	}

	public void setData(String data) {
		this.data = LocalDate.parse(data);
	}

	public long getEstacaoId() {
		return this.estacaoMeteriologica.getId();
	}

	public EstacaoMeteriologica getEstacaoMeteriologica() {
		return estacaoMeteriologica;
	}

	public void setEstacaoMeteriologica(EstacaoMeteriologica estacaoMeteriologica) {
		this.estacaoMeteriologica = estacaoMeteriologica;
	}

}
