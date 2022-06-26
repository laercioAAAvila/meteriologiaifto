package br.com.laercio.meteriologiaifto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.repository.EstacaoMeteriologicaRepository;

@Service
public class EstacaoMeteriologicaServiceImpl implements EstacaoMeteriologicaService {
	@Autowired
	EstacaoMeteriologicaRepository estacaoMeteriologicaRepository;
	
	@Override
	public List<EstacaoMeteriologica> findAll() {
		return this.estacaoMeteriologicaRepository.findAll();
	}
}
