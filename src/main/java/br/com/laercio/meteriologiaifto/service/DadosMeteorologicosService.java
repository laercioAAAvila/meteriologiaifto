package br.com.laercio.meteriologiaifto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.laercio.meteriologiaifto.model.DadosMeteorologicos;
import br.com.laercio.meteriologiaifto.repository.DadosMeteorologicosRepository;

@Service
public class DadosMeteorologicosService {
	@Autowired
	private DadosMeteorologicosRepository DadosMeteorologicosRepository;

	public List<DadosMeteorologicos> findAll() {
		return this.DadosMeteorologicosRepository.findAll();
	}

	public void save(DadosMeteorologicos DadosMeteorologicos) {
		this.DadosMeteorologicosRepository.save(DadosMeteorologicos);
	}

	public Page<DadosMeteorologicos> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.DadosMeteorologicosRepository.findAll(pageable);
	}

	public Optional<DadosMeteorologicos> findByEstacaoId(Long id) {
		return this.DadosMeteorologicosRepository.findById(id);

	}

	// ======================================//
	public Page<DadosMeteorologicos> findPaginatedById(int pageNo, int pageSize, String sortField, String sortDirection,
			long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.DadosMeteorologicosRepository.findAllByEstacaoId(estacaoId, pageable);
	}

	// ======================================//
	public Page<DadosMeteorologicos> findPaginatedByIdHoje(int pageNo, int pageSize, String sortField,
			String sortDirection, long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.DadosMeteorologicosRepository.findPaginatedByIdHoje(estacaoId, pageable);
	}

	// ======================================//
	public Page<DadosMeteorologicos> findPaginatedByIdSete(int pageNo, int pageSize, String sortField,
			String sortDirection, long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.DadosMeteorologicosRepository.findPaginatedByIdSete(estacaoId, pageable);
	}

	// ======================================//
	public Page<DadosMeteorologicos> findPaginatedByIdTrinta(int pageNo, int pageSize, String sortField,
			String sortDirection, long estacaoId) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.DadosMeteorologicosRepository.findPaginatedByIdTrinta(estacaoId, pageable);
	}

}
