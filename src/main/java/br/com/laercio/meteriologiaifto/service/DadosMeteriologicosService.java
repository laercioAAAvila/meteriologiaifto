package br.com.laercio.meteriologiaifto.service;

import java.util.List;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;

public interface DadosMeteriologicosService {
	public List<DadosMeteriologicos> findAllByIdEstacao(long idEstacao);
}
