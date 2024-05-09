package br.com.laercio.meteriologiaifto.controller.detalhes.estacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.laercio.meteriologiaifto.model.DadosMeteorologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.DadosMeteorologicosService;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@Controller
public class TrintaEstacaoController {

	@Autowired
	DadosMeteorologicosService DadosMeteorologicosService;
	@Autowired
	EstacaoMeteriologicaService estacaoMetoriologicaService;

	@RequestMapping(method = RequestMethod.GET, value = "/estacao/{id}/trinta")
	public String trinta(Model model, @PathVariable("id") int estacaoId) {
		return findPaginatedByIdTrinta(1, "temperatura", "asc", model, estacaoId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/estacao/{id}/trinta/{pageNo}")
	public String findPaginatedByIdTrinta(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model,
			@PathVariable("id") int estacaoId) {
		int pageSize = 5;

		Page<DadosMeteorologicos> page = DadosMeteorologicosService.findPaginatedByIdTrinta(pageNo, pageSize, sortField, sortDir, estacaoId);
		List<DadosMeteorologicos> DadosMeteorologicos = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMetoriologicaService.findAll();
		Optional<EstacaoMeteriologica> est = this.estacaoMetoriologicaService.findById(estacaoId);
		model.addAttribute("est", est.get());
		model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
		model.addAttribute("DadosMeteorologicos", DadosMeteorologicos);

		return "page/estacao";
	}
}
