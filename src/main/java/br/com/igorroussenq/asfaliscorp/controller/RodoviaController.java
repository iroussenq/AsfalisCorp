package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;
import br.com.igorroussenq.asfaliscorp.service.RodoviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rodovia")
public class RodoviaController {

    @Autowired
    private RodoviaService rodoviaService;

    @GetMapping("/consultar")
    public List<RodoviaModel> consultar() {
        return rodoviaService.consultar();
    }

    @PostMapping("/cadastrar")
    public RodoviaModel cadastrar(@RequestBody @Valid RodoviaModel model) {
        return rodoviaService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public RodoviaModel alterar(@RequestBody @Valid RodoviaModel model) {
        return rodoviaService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public RodoviaModel remover(@PathVariable UUID id) {
        return rodoviaService.remover(id);
    }

    @GetMapping("/rodovia-5-mortes")
    public List<RodoviaModel> rodoviaCincoMortes() {
        return rodoviaService.buscaRodoviaComMaisQueCincoMortes();
    }


}
