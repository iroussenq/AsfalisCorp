package br.com.igorroussenq.asfaliscorp.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class AcidenteModel {
    private UUID idCondutor;
    private UUID idPolicial;
    private UUID idRodovia;
    private UUID idVeiculo;
    private LocalDate dataDoAcidente;
    private String relatorio;
    private Integer casualidades;
}
