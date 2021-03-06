package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.model.PolicialModel;
import br.com.igorroussenq.asfaliscorp.service.PolicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/policial")
public class PolicialController {

    @Autowired
    private PolicialService policialService;

    @GetMapping("/consultar")
    public List<PolicialModel> consultar() {
        return policialService.consultar();
    }

    @PostMapping("/cadastrar")
    public PolicialModel cadastrar(@RequestBody @Valid PolicialModel model) {
        return policialService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public PolicialModel alterar(@RequestBody @Valid PolicialModel model) {
        return policialService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public PolicialModel remover(@PathVariable UUID id) {
        return policialService.remover(id);
    }
}
