package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Veiculo {

    private UUID id;
    private String nome;
    private String placa;
    private Integer ano;

    public Veiculo(String nome,String placa,Integer ano){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
    }
}
