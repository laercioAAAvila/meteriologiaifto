package br.com.laercio.meteriologiaifto.repository;

import br.com.laercio.meteriologiaifto.model.DadosMeteorologicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DadosMeteorologicosRepository extends JpaRepository<DadosMeteorologicos, Long> {

	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE estacao_id = ?1", nativeQuery = true)
	Page<DadosMeteorologicos> findAllByEstacaoId(long id, Pageable pageable);

	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE (estacao_id = ?1) AND data = CURDATE()", nativeQuery = true)
	Page<DadosMeteorologicos> findPaginatedByIdHoje(long id, Pageable pageable);

	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE (estacao_id = ?1) AND (data between adddate(now(),-7) and now())", nativeQuery = true)
	Page<DadosMeteorologicos> findPaginatedByIdSete(long id, Pageable pageable);

	@Query(value = "SELECT * FROM DADOS_METERIOLOGICOS WHERE (estacao_id = ?1) AND (data between adddate(now(),-30) and now())", nativeQuery = true)
	Page<DadosMeteorologicos> findPaginatedByIdTrinta(long id, Pageable pageable);
}

