package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class Policial extends Pessoa{

    private String patente;

    public Policial(String nome, String cpf, LocalDateTime dataDeNascimento, String patente) {
        super(nome, cpf, dataDeNascimento);
        this.patente = patente;
    }

    public Policial editar(final String nome, String cpf,final LocalDate niver, final String cpf) {
        super.editar(nome, niver);
        this.cpf = StringUtils.extractNumbers(cpf);
        return this;
    }
    }