package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;

import java.util.List;
import java.util.UUID;

public interface RodoviaService {
    List<Rodovia> consultar();
    Rodovia consultarUm(UUID id);
    Rodovia cadastrar(RodoviaModel model);
    Rodovia alterar(UUID id, RodoviaModel model);
    Rodovia remover(UUID id);
}