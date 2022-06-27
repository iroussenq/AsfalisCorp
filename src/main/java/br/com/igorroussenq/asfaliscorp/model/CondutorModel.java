package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.enums.EnumStatusCondutor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class CondutorModel {

    @NotNull
    @NotBlank
    @Length(min = 2, max = 30)
    private String nome;

    @NotNull(message = "A data de aniversário não pode ser nula")
    private LocalDate dataDeNascimento;


    @NotNull
    private String cpf;

    @NotNull
    private EnumStatusCondutor statusCondutor;
}