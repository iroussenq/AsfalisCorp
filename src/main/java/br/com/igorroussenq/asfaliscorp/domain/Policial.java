package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.helper.StringUtils;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class Policial extends Pessoa{

    private String patente;

    public Policial(String nome, String cpf, LocalDate dataDeNascimento, String patente) {
        super(nome, cpf, dataDeNascimento);
        this.patente = patente;
    }

    public Policial editar(final String nome,final String cpf,final LocalDate dataDeNascimento, final String patente) {
        super.editar(nome,cpf,dataDeNascimento);
        this.patente = patente;
        return this;
    }
    }