package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;

import java.util.List;
import java.util.UUID;

public interface CondutorService {
    List<CondutorModel> consultar();
    CondutorModel consultar(UUID id);
    CondutorModel cadastrar(CondutorModel model);
    CondutorModel alterar(CondutorModel model);
    CondutorModel remover(UUID id);
}
