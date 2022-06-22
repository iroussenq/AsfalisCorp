package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Multa {

    private UUID id;
    private String condicaoDaMulta;
    private BigDecimal valorDaMulta;

    public Multa(final String condicaoDaMulta,final BigDecimal valorDaMulta){
        this.id = UUID.randomUUID();
        this.condicaoDaMulta = condicaoDaMulta;
        this.valorDaMulta = valorDaMulta;
    }

    public Multa editar(final String condicaoDaMulta,final BigDecimal valorDaMulta){
        this.id = UUID.randomUUID();
        this.condicaoDaMulta = condicaoDaMulta;
        this.valorDaMulta = valorDaMulta;
        return this;
    }

}
