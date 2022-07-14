package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.model.AcidenteModel;
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
    public List<AcidenteModel> consultar() {
        return acidenteService.consultar();
    }

    @PostMapping("/cadastrar")
    public AcidenteModel cadastrar(@RequestBody AcidenteModel model) {
        return acidenteService.cadastrar(model);
    }

    @DeleteMapping("/remover/{id}")
    public AcidenteModel remover(@PathVariable UUID id) {
        return acidenteService.remover(id);
    }

}

