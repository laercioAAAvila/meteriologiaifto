package br.com.laercio.meteriologiaifto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String estacao(Model model) {
        List<DadosMeteriologicos> dadosMeteriologicos = dadosMeteriologicosService.findAll();
        List<EstacaoMeteriologica> estacaoMeteriologicas = estacaoMetoriologicaService.findAll();
        model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);
        model.addAttribute("estacaoMeteriologicas", estacaoMeteriologicas);
        return "index";
    }
}
