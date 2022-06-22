package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Multa;
import br.com.igorroussenq.asfaliscorp.model.MultaModel;

import java.util.List;
import java.util.UUID;

public interface MultaService {
    List<Multa> consultar();
    Multa consultarUm(UUID id);
    List<Multa> consultarTodos(List<UUID> ids);
    Multa cadastrar(MultaModel model);
    Multa alterar(UUID id,MultaModel model);
    Multa remover(UUID id);

}
