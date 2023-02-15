package br.com.laercio.meteriologiaifto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.laercio.meteriologiaifto.VO.DadosMeteriologicosVO;
import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@RestController
public class DadosMeteriologicosController {

	@Autowired
	private EstacaoMeteriologicaService estacaoMeteriologicaService;

	@RequestMapping(method = RequestMethod.POST, value = "/api/estacao/dados")
	public void adicionar(@RequestBody DadosMeteriologicosVO dadosMeteriologicosVO) {
		Optional<EstacaoMeteriologica> estacao = estacaoMeteriologicaService.findById(dadosMeteriologicosVO.getEstacaoid());
		DadosMeteriologicos dadosMeteriologicos = new DadosMeteriologicos();
		dadosMeteriologicos.setTemperatura(dadosMeteriologicosVO.getTemperatura());
		dadosMeteriologicos.setDirecaoVento(dadosMeteriologicosVO.getDirecaoVento());
		dadosMeteriologicos.setVelocidadeVento(dadosMeteriologicosVO.getVelocidadeVento());
		dadosMeteriologicos.setPrecipitacaoChuva(dadosMeteriologicosVO.getPrecipitacaoChuva());
		dadosMeteriologicos.setRadicaoSolar(dadosMeteriologicosVO.getRadicaoSolar());
		dadosMeteriologicos.setUmidadeAr(dadosMeteriologicosVO.getUmidadeAr());
		dadosMeteriologicos.setData(dadosMeteriologicosVO.getData());
		estacao.get().addDadosMeteriologicos(dadosMeteriologicos);
		this.estacaoMeteriologicaService.save(estacao.get());
	}
}