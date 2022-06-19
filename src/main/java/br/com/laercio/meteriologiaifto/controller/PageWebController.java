package br.com.laercio.meteriologiaifto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.laercio.meteriologiaifto.model.DadosMeteriologicos;
import br.com.laercio.meteriologiaifto.service.DadosMeteriologicosService;

@Controller
public class PageWebController {

	@Autowired
	DadosMeteriologicosService dadosMeteriologicosService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String novaCompra(Model model) {
        List<DadosMeteriologicos> dadosMeteriologicos = dadosMeteriologicosService.findAll();
        model.addAttribute("dadosMeteriologicos", dadosMeteriologicos);
        return "index";
    }
}
