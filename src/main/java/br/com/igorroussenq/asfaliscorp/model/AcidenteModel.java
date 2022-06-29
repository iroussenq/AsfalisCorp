package br.com.igorroussenq.asfaliscorp.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AcidenteModel {
    private UUID idCondutor;
    private UUID idPolicial;
    private UUID idRodovia;
    private UUID idVeiculo;
}
