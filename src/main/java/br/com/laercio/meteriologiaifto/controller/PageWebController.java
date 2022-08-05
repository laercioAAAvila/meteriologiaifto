package br.com.laercio.meteriologiaifto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.DadosMeteriologicosService;
import br.com.laercio.meteriologiaifto.service.EstacaoMetoriologicaService;

@Controller
public class PageWebController {

	@Autowired
	DadosMeteriologicosService dadosMeteriologicosService;
	@Autowired
	EstacaoMetoriologicaService estacaoMetoriologicaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String inicio(Model model) {
        List<DadosMeteriologicos> dadosMeteriologicos = dadosMeteriologicosService.findAll();
        List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMetoriologicaService.findAll();
        model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);
        model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
        return "index";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/estacao/{id}")
	public String estacao(@PathVariable(value = "id") long idEstacao,Model model) {
		Optional<EstacaoMeteriologica> estacao = estacaoMetoriologicaService.findById(idEstacao);
		EstacaoMeteriologica est = estacao.get();
		List<DadosMeteriologicos> dadosMeteriologicos = dadosMeteriologicosService.findAllById(idEstacao);
		List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMetoriologicaService.findAll();
		
		model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
		model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);
		model.addAttribute("est", est);
		return "base/estacao";
	}
}
