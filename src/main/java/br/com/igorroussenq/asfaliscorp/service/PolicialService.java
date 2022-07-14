package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.model.PolicialModel;

import java.util.List;
import java.util.UUID;

public interface PolicialService {

    List<PolicialModel> consultar();
    PolicialModel consultar(UUID id);
    PolicialModel cadastrar(PolicialModel model);
    PolicialModel alterar(PolicialModel model);
    PolicialModel remover(UUID id);
}
