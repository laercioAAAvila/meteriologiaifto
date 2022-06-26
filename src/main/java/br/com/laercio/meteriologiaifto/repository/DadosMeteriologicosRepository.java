package br.com.laercio.meteriologiaifto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;

public interface DadosMeteriologicosRepository extends JpaRepository<DadosMeteriologicos, Long>{
	
	  List<DadosMeteriologicos> findByIdEstacao(Long idEstacao);
}
