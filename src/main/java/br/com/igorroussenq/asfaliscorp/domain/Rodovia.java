package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Rodovia {
    private UUID id;
    private String nome;
    private Integer km;
    private Integer mortes;

    public Rodovia(String nome, Integer km, Integer mortes){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.km = km;
        this.mortes = mortes;
    }

    public Rodovia editar(String nome, Integer km, Integer mortes){
        this.nome = nome;
        this.km = km;
        this.mortes = mortes;
        return this;
    }

}
