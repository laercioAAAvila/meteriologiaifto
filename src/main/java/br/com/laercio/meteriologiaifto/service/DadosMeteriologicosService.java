package br.com.laercio.meteriologiaifto.service;

import java.util.List;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;

public interface DadosMeteriologicosService {
	public List<DadosMeteriologicos> findAll();
	public List<DadosMeteriologicos> findAllById(long idEstacao);
}
