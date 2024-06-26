package br.com.laercio.meteriologiaifto.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@RestController
public class EstacaoMeteriologicaController {

    @Autowired
    private EstacaoMeteriologicaService estacaoMeteriologicaService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/estacao")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> adicionar(@RequestBody EstacaoMeteriologica estacaoMeteriologica) {
        this.estacaoMeteriologicaService.save(estacaoMeteriologica);

        HashMap<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(estacaoMeteriologica.getId()));
        return map;
    }
}
