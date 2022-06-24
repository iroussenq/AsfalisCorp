package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.model.AcidenteModel;
import br.com.igorroussenq.asfaliscorp.model.AdicionarMultaModel;
import br.com.igorroussenq.asfaliscorp.service.AcidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/acidente")
public class AcidenteController {

    @Autowired
    private AcidenteService acidenteService;

    @GetMapping("/consultar")
    public List<Acidente> consultar() {
        return acidenteService.consultar();
    }

    @PostMapping("/cadastrar")
    public Acidente cadastrar(@RequestBody AcidenteModel model) {
        return acidenteService.cadastrar(model);
    }

    @PutMapping("/adicionar-multa/{id}")
    public Acidente adicionarMulta(@PathVariable UUID id, @RequestBody AdicionarMultaModel model) {
        return acidenteService.adicionarMulta(id, model);
    }

}
