package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;
import br.com.igorroussenq.asfaliscorp.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/consultar")
    public List<Veiculo> consultar() {
        return veiculoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Veiculo cadastrar(@RequestBody @Valid VeiculoModel model) {
        return veiculoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Veiculo alterar(@PathVariable UUID id, @RequestBody @Valid VeiculoModel model) {
        return veiculoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Veiculo remover(@PathVariable UUID id) {
        return veiculoService.remover(id);
    }
}
