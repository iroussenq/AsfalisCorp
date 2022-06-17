package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class Policial extends Pessoa{

    private String patente;

    protected Policial(String nome, String cpf, LocalDateTime dataDeNascimento,String patente) {
        super(nome, cpf, dataDeNascimento);
        this.patente = patente;
    }

}
