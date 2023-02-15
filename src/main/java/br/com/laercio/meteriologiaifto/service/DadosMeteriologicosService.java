package br.com.laercio.meteriologiaifto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.repository.DadosMeteriologicosRepository;

@Service
public class DadosMeteriologicosService {
	@Autowired
	private DadosMeteriologicosRepository dadosMeteriologicosRepository;

	public List<DadosMeteriologicos> findAll() {
		return this.dadosMeteriologicosRepository.findAll();
	}

	public void save(DadosMeteriologicos dadosMeteriologicos) {
		this.dadosMeteriologicosRepository.save(dadosMeteriologicos);
	}

	public Page<DadosMeteriologicos> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dadosMeteriologicosRepository.findAll(pageable);
	}

	public Optional<DadosMeteriologicos> findByEstacaoId(Long id) {
		return this.dadosMeteriologicosRepository.findById(id);

	}

	// ======================================//
	public Page<DadosMeteriologicos> findPaginatedById(int pageNo, int pageSize, String sortField, String sortDirection,
			long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dadosMeteriologicosRepository.findAllByEstacaoId(estacaoId, pageable);
	}

	// ======================================//
	public Page<DadosMeteriologicos> findPaginatedByIdHoje(int pageNo, int pageSize, String sortField,
			String sortDirection, long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dadosMeteriologicosRepository.findPaginatedByIdHoje(estacaoId, pageable);
	}

	// ======================================//
	public Page<DadosMeteriologicos> findPaginatedByIdSete(int pageNo, int pageSize, String sortField,
			String sortDirection, long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dadosMeteriologicosRepository.findPaginatedByIdSete(estacaoId, pageable);
	}

	// ======================================//
	public Page<DadosMeteriologicos> findPaginatedByIdTrinta(int pageNo, int pageSize, String sortField,
			String sortDirection, long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dadosMeteriologicosRepository.findPaginatedByIdTrinta(estacaoId, pageable);
	}

}
