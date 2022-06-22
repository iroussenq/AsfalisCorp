package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.enums.EnumStatusCondutor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class CondutorModel {
    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private EnumStatusCondutor statusCondutor;
}
