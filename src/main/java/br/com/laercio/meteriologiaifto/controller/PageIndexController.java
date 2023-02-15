package br.com.laercio.meteriologiaifto.controller;

import java.util.List;

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
public class PageIndexController {

	@Autowired
	DadosMeteriologicosService dadosMeteriologicosService;
	@Autowired
	EstacaoMeteriologicaService estacaoMetoriologicaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String inicio(Model model) {
        return findPaginated(1, "temperatura", "asc", model);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<DadosMeteriologicos> page = dadosMeteriologicosService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<DadosMeteriologicos> dadosMeteriologicos = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMetoriologicaService.findAll();
		
		model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
		model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);
		
		return "index";
	}
}
