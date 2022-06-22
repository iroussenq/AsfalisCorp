package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
public class Acidente {

    private UUID id;
    private Rodovia rodovia;
    private List<Multa> multas;
    private Policial policial;
    private Condutor condutor;
    private LocalDateTime dataDoAcidente;

    public Acidente(final Policial policial,final Condutor condutor,final Rodovia rodovia){
        this.id = UUID.randomUUID();
        this.rodovia = rodovia;
        this.condutor = condutor;
        this.policial = policial;
        this.dataDoAcidente = dataDoAcidente;
    }

    public Acidente addMulta(final List<Multa> multas) {
        this.multas.addAll(multas);
        return this;
    }

}