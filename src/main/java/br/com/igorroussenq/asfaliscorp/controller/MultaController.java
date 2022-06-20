package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Multa;
import br.com.igorroussenq.asfaliscorp.model.MultaModel;
import br.com.igorroussenq.asfaliscorp.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/multa")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @GetMapping("/consultar")
    public List<Multa> consultar() {
        return multaService.consultar();
    }

    @GetMapping("/consultar_um/{id}")
    public Multa consultarUm(@PathVariable UUID id) {
        return multaService.consultarUm(id);
    }

    @PostMapping("/cadastrar")
    public Multa cadastrar(@RequestBody MultaModel model) {
        return multaService.cadastrar(model);
    }

    @DeleteMapping("/remover/{id}")
    public Multa remover(@PathVariable UUID id) {
        return multaService.remover(id);
    }
}
