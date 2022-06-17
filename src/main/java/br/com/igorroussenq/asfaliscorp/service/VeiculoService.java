package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;

import java.util.List;
import java.util.UUID;

public interface VeiculoService {
    List<Veiculo> consultar();
    Veiculo consultarUm(UUID id);
    Veiculo cadastrar(VeiculoModel model);
    Veiculo alterar(UUID id, VeiculoModel model);
    Veiculo remover(UUID id);
}