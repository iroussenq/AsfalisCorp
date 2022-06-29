package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.model.AcidenteModel;
import br.com.igorroussenq.asfaliscorp.model.AdicionarMultaModel;

import java.util.List;
import java.util.UUID;

public interface AcidenteService {
    List<Acidente> consultar();
    Acidente remover(UUID id);
    Acidente consultarUm(UUID id);
    Acidente cadastrar(AcidenteModel model);
    Acidente adicionarMulta(UUID id, AdicionarMultaModel model);
}
