package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
public class Acidente {

    private UUID id;
    private Rodovia rodovia;
    private Veiculo veiculo;
    private Policial policial;
    private Condutor condutor;
    private LocalDate dataDoAcidente;

    private String relatorio;

    private Integer casualidades;

    public Acidente(final Condutor condutor,final Policial policial,final Rodovia rodovia, final Veiculo veiculo, final LocalDate dataDoAcidente, final String relatorio,final Integer casualidades){
        this.id = UUID.randomUUID();
        this.rodovia = rodovia;
        this.condutor = condutor;
        this.policial = policial;
        this.veiculo = veiculo;
        this.dataDoAcidente = dataDoAcidente;
        this.relatorio = relatorio;
        this.casualidades = casualidades;
    }

}