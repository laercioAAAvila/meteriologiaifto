package br.com.laercio.meteriologiaifto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.repository.DadosMeteriologicosRepository;

@Service
public class DadosMeteriologicosServiceImpl implements DadosMeteriologicosService {
	@Autowired
	private DadosMeteriologicosRepository dadosMeteriologicosRepository;
	
	@Override
	public List<DadosMeteriologicos> findAll(){
		return this.dadosMeteriologicosRepository.findAll();
	}

	@Override
	public List<DadosMeteriologicos> findAllById(long idEstacao) {
		
		return this.dadosMeteriologicosRepository.findAllById(idEstacao);
	}
	
}
