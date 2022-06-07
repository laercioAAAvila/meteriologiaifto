package br.com.laercio.meteriologiaifto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.repository.EstacaoMeteriologicaRepository;

@RestController
@RequestMapping("/api")
public class EstacaoMeteriologicaController {

	@Autowired
	private EstacaoMeteriologicaRepository estacaoMeteriologicaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstacaoMeteriologica adicionar(@RequestBody EstacaoMeteriologica estacaoMeteriologica) {
		return estacaoMeteriologicaRepository.save(estacaoMeteriologica);
	}
}
