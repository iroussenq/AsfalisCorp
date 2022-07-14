package br.com.igorroussenq.asfaliscorp.service;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.model.AcidenteModel;

import java.util.List;
import java.util.UUID;

public interface AcidenteService {
    List<AcidenteModel> consultar();
    AcidenteModel remover(UUID id);
    AcidenteModel consultar(UUID id);
    AcidenteModel cadastrar(AcidenteModel model);
}
