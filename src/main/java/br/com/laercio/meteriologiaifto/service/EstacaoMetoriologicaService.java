package br.com.laercio.meteriologiaifto.service;

import java.util.List;
import java.util.Optional;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;

public interface EstacaoMetoriologicaService {
	public List<EstacaoMeteriologica> findAll();
	Optional<EstacaoMeteriologica> findById(long id);
}
