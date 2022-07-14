package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.enums.EnumStatusCondutor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CondutorModel {
    private UUID id;

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

    private Long idade;

    private Boolean documentoValido;

    public CondutorModel(Condutor condutor) {
        this.id = condutor.getId();
        this.nome = condutor.getNome();
        this.dataDeNascimento = condutor.getDataDeNascimento();
        this.cpf = condutor.getCpf();
        this.idade = condutor.getIdade();
        this.statusCondutor = condutor.getStatusCondutor();
        this.documentoValido = condutor.getDocumentoValido();
    }
}