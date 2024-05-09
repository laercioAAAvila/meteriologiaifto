package br.com.laercio.meteriologiaifto.VO;

public class DadosMeteorologicosVO {
	
	
	private double temperatura;
	private double umidadeAr;
	private double velocidadeVento;
	private String direcaoVento;
	private double precipitacaoChuva;
	private double radicaoSolar;
	private String data;
	private long estacaoid;

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

	public long getEstacaoid() {
		return estacaoid;
	}

	public void setEstacaoid(long estacaoid) {
		this.estacaoid = estacaoid;
	}

}
