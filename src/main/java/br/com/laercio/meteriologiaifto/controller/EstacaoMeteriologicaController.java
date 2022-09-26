package br.com.laercio.meteriologiaifto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.repository.EstacaoMeteriologicaRepository;

@RestController
public class EstacaoMeteriologicaController {

	@Autowired
	private EstacaoMeteriologicaRepository estacaoMeteriologicaRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/api/estacao")
	@ResponseStatus(HttpStatus.CREATED)
	public long adicionar(@RequestBody EstacaoMeteriologica estacaoMeteriologica) {
		estacaoMeteriologicaRepository.save(estacaoMeteriologica);
		return estacaoMeteriologica.getId();
	}
	
	
}
