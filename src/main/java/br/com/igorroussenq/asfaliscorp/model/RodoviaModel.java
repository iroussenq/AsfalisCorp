package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class RodoviaModel {

    private UUID id;
    private String nome;
    private String cep;
    private Integer mortes;

    public RodoviaModel(Rodovia rodovia) {
        this.id = rodovia.getId();
        this.nome = rodovia.getNome();
        this.cep = rodovia.getCep();
        this.mortes = rodovia.getMortes();
    }
}
