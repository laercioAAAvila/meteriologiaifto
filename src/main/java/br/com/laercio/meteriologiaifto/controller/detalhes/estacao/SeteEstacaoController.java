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

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.DadosMeteriologicosService;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@Controller
public class SeteEstacaoController {

	@Autowired
	DadosMeteriologicosService dadosMeteriologicosService;
	@Autowired
	EstacaoMeteriologicaService estacaoMetoriologicaService;

	@RequestMapping(method = RequestMethod.GET, value = "/estacao/{id}/sete")
	public String sete(Model model, @PathVariable("id") int estacaoId) {
		return findPaginatedBySete(1, "temperatura", "asc", model, estacaoId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/estacao/{id}/sete/{pageNo}")
	public String findPaginatedBySete(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model,
			@PathVariable("id") int estacaoId) {
		int pageSize = 5;

		Page<DadosMeteriologicos> page = dadosMeteriologicosService.findPaginatedByIdSete(pageNo, pageSize, sortField, sortDir, estacaoId);
		List<DadosMeteriologicos> dadosMeteriologicos = page.getContent();

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
		model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);

		return "page/estacao";
	}
}
