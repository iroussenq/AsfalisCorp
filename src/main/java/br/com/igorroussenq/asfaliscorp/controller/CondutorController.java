package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import br.com.igorroussenq.asfaliscorp.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/condutor")
public class CondutorController {

    @Autowired
    private CondutorService condutorService;

    @GetMapping("/consultar")
    public List<Condutor> consultar() {
        return condutorService.consultar();
    }

    @PostMapping("/cadastrar")
    public Condutor cadastrar(@RequestBody @Valid CondutorModel model) {
        return condutorService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Condutor alterar(@PathVariable UUID id, @RequestBody @Valid CondutorModel model) {
        return condutorService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Condutor remover(@PathVariable UUID id) {
        return condutorService.remover(id);
    }
}
