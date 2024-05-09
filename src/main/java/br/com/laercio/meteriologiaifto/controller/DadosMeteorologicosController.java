package br.com.laercio.meteriologiaifto.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.laercio.meteriologiaifto.VO.DadosMeteorologicosVO;
import br.com.laercio.meteriologiaifto.model.DadosMeteorologicos;
import br.com.laercio.meteriologiaifto.model.EstacaoMeteriologica;
import br.com.laercio.meteriologiaifto.service.EstacaoMeteriologicaService;

@RestController
public class DadosMeteorologicosController {

    @Autowired
    private EstacaoMeteriologicaService estacaoMeteriologicaService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/estacao/dados")
    public Map<String, String> adicionar(@RequestBody DadosMeteorologicosVO DadosMeteorologicosVO) {
        Optional<EstacaoMeteriologica> estacao = estacaoMeteriologicaService.findById(DadosMeteorologicosVO.getEstacaoid());
        DadosMeteorologicos DadosMeteorologicos = new DadosMeteorologicos();
        DadosMeteorologicos.setTemperatura(DadosMeteorologicosVO.getTemperatura());
        DadosMeteorologicos.setDirecaoVento(DadosMeteorologicosVO.getDirecaoVento());
        DadosMeteorologicos.setVelocidadeVento(DadosMeteorologicosVO.getVelocidadeVento());
        DadosMeteorologicos.setPrecipitacaoChuva(DadosMeteorologicosVO.getPrecipitacaoChuva());
        DadosMeteorologicos.setRadicaoSolar(DadosMeteorologicosVO.getRadicaoSolar());
        DadosMeteorologicos.setUmidadeAr(DadosMeteorologicosVO.getUmidadeAr());
        DadosMeteorologicos.setData(DadosMeteorologicosVO.getData());
        estacao.get().addDadosMeteorologicos(DadosMeteorologicos);
        this.estacaoMeteriologicaService.save(estacao.get());


        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "sucess");
        return map;
    }
}
