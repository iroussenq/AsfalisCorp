package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.model.PolicialModel;

import java.util.List;
import java.util.UUID;

public interface PolicialService {

    List<Policial> consultar();
    Policial consultarUm(UUID id);
    Policial cadastrar(PolicialModel model);
    Policial alterar(UUID id, PolicialModel model);
    Policial remover(UUID id);
}
