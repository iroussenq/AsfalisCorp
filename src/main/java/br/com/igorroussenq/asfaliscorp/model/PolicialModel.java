package br.com.igorroussenq.asfaliscorp.model;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class PolicialModel {
    private String nome;
    private LocalDateTime dataDeNascimento;
    private String cpf;
    private String patente;
}
