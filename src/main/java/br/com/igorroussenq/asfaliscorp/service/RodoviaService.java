package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;

import java.util.List;
import java.util.UUID;

public interface RodoviaService {
    List<RodoviaModel> consultar();
    RodoviaModel consultar(UUID id);
    RodoviaModel cadastrar(RodoviaModel model);
    RodoviaModel alterar(RodoviaModel model);
    RodoviaModel remover(UUID id);
}