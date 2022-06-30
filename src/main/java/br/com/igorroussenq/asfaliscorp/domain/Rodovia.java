package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Rodovia {
    private UUID id;
    private String nome;
    private String cep;
    private Integer mortes;

    public Rodovia(String nome, String cep, Integer mortes){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cep = cep;
        this.mortes = mortes;
    }

    public Rodovia editar(String nome, String cep, Integer mortes){
        this.nome = nome;
        this.cep = cep;
        this.mortes = mortes;
        return this;
    }

    public String getCep() {
        if (this.cep.length() == 8) {
            return cep.replaceAll("/^[0-9]{8}$/", "$1-$2");
        }
        return cep;
    }


}
