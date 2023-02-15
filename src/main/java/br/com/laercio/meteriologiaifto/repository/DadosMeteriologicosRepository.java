package br.com.laercio.meteriologiaifto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;

@Repository
public interface DadosMeteriologicosRepository extends JpaRepository<DadosMeteriologicos, Long> {

	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE estacao_id = ?1", nativeQuery = true)
	Page<DadosMeteriologicos> findAllByEstacaoId(long id, Pageable pageable);
	
	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE (estacao_id = ?1) AND (data between adddate(now(),-1) and now())", nativeQuery = true)
	Page<DadosMeteriologicos> findPaginatedByIdHoje(long id, Pageable pageable);
	
	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE (estacao_id = ?1) AND (data between adddate(now(),-7) and now())", nativeQuery = true)
	Page<DadosMeteriologicos> findPaginatedByIdSete(long id, Pageable pageable);
	
	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE (estacao_id = ?1) AND (data between adddate(now(),-30) and now())", nativeQuery = true)
	Page<DadosMeteriologicos> findPaginatedByIdTrinta(long id, Pageable pageable);
	
}
