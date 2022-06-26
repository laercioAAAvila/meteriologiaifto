package br.com.laercio.meteriologiaifto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.DadosMeteriologicosService;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@Controller
public class PageWebController {

	@Autowired
	DadosMeteriologicosService dadosMeteriologicosService;
	@Autowired
	EstacaoMeteriologicaService estacaoMeteriologicaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idEstacao}")
	public String novaCompra(@PathVariable(value = "idEstacao") long idEstacao, Model model) {
        try {
			List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMeteriologicaService.findAll();
			model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
			List<DadosMeteriologicos> dadosMeteriologicos = dadosMeteriologicosService.findAllByIdEstacao(idEstacao);
			model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);
		} catch (Exception e) {
			System.out.println(e);
		}
        
        return "index";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String novaCompra(Model model) {
        
		List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMeteriologicaService.findAll();
		model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
		
        return "index";
	}
}