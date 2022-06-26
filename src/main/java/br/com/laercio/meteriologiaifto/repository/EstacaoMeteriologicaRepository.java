package br.com.laercio.meteriologiaifto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;

@Repository
public interface EstacaoMeteriologicaRepository extends JpaRepository<EstacaoMeteriologica, Long> {
}
