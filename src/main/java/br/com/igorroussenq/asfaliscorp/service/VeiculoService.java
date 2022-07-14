package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;

import java.util.List;
import java.util.UUID;

public interface VeiculoService {
    List<VeiculoModel> consultar();
    VeiculoModel consultar(UUID id);
    VeiculoModel cadastrar(VeiculoModel model);
    VeiculoModel alterar(VeiculoModel model);
    VeiculoModel remover(UUID id);
}