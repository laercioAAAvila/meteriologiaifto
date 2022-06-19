package br.com.laercio.meteriologiaifto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.repository.DadosMeteriologicosRepository;

@RestController
public class DadosMeteriologicosController {

	@Autowired
	private DadosMeteriologicosRepository dadosMeteriologicosRepository;
	
	@RequestMapping(method = RequestMethod.POST, value ="/api/estacao/dados")
	public DadosMeteriologicos adicionar (@RequestBody DadosMeteriologicos dadosMeteriologicos) {
		return dadosMeteriologicosRepository.save(dadosMeteriologicos);				
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/api/estacao/dados")
//	public List<DadosMeteriologicos> mostrar() {
//		return dadosMeteriologicosRepository.findAll();
//	}
}
