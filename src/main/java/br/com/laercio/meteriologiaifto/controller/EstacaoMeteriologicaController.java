package br.com.laercio.meteriologiaifto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.repository.EstacaoMeteriologicaRepository;

@RestController
public class EstacaoMeteriologicaController {

	@Autowired
	private EstacaoMeteriologicaRepository estacaoMeteriologicaRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/api/estacao")
	@ResponseStatus(HttpStatus.CREATED)
	public EstacaoMeteriologica adicionar(@RequestBody EstacaoMeteriologica estacaoMeteriologica) {
		return estacaoMeteriologicaRepository.save(estacaoMeteriologica);
	}
}
