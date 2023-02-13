package br.com.laercio.meteriologiaifto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.repository.EstacaoMeteriologicaRepository;

@Service
public class EstacaoMeteriologicaService {
	@Autowired
	private EstacaoMeteriologicaRepository estacaoMeteriologicaRepository;

	public Optional<EstacaoMeteriologica> findById(long id) {
		return this.estacaoMeteriologicaRepository.findById(id);

	}

	public List<EstacaoMeteriologica> findAll() {
		return this.estacaoMeteriologicaRepository.findAll();
	}
}
