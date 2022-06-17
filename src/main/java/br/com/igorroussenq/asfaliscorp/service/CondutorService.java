package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;

import java.util.List;
import java.util.UUID;

public interface CondutorService {
    List<Condutor> consultar();
    Condutor consultarUm(UUID id);
    Condutor cadastrar(CondutorModel model);
    Condutor alterar(UUID id, CondutorModel model);
    Condutor remover(UUID id);
}
