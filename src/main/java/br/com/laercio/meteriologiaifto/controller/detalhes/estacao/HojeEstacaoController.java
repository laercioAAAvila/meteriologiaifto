package br.com.laercio.meteriologiaifto.controller.detalhes.estacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.laercio.meteriologiaifto.model.DadosMeteorologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.DadosMeteorologicosService;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@Controller
@RequestMapping("/estacao")
public class HojeEstacaoController {

	private final DadosMeteorologicosService dadosMeteorologicosService;
	private final EstacaoMeteriologicaService estacaoMeteorologicaService;

	@Autowired
	public HojeEstacaoController(DadosMeteorologicosService dadosMeteorologicosService, EstacaoMeteriologicaService estacaoMeteorologicaService) {
		this.dadosMeteorologicosService = dadosMeteorologicosService;
		this.estacaoMeteorologicaService = estacaoMeteorologicaService;
	}

	@GetMapping("/{id}/hoje")
	public String getDadosMeteorologicosHoje(@PathVariable("id") int estacaoId, Model model) {
		return findPaginatedByHoje(1, "temperatura", "asc", estacaoId, model);
	}

	@GetMapping("/{id}/hoje/{pageNo}")
	public String findPaginatedByHoje(@PathVariable("pageNo") int pageNo,
									  @RequestParam("sortField") String sortField,
									  @RequestParam("sortDir") String sortDir,
									  @PathVariable("id") int estacaoId,
									  Model model) {
		int pageSize = 5;

		Page<DadosMeteorologicos> page = dadosMeteorologicosService.findPaginatedByIdHoje(pageNo, pageSize, sortField, sortDir, estacaoId);
		List<DadosMeteorologicos> dadosMeteorologicosList = page.getContent();

		populateModelWithPaginationAttributes(page, pageNo, sortField, sortDir, model);

		List<EstacaoMeteriologica> estacoesMeteorologicas = estacaoMeteorologicaService.findAll();
		Optional<EstacaoMeteriologica> estacaoOptional = estacaoMeteorologicaService.findById(estacaoId);

		estacaoOptional.ifPresent(estacao -> model.addAttribute("est", estacao));
		model.addAttribute("estacaoMeteorologicas", estacoesMeteorologicas);
		model.addAttribute("dadosMeteorologicos", dadosMeteorologicosList);

		return "page/estacao";
	}

	private void populateModelWithPaginationAttributes(Page<?> page, int currentPage, String sortField, String sortDir, Model model) {
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	}
}

