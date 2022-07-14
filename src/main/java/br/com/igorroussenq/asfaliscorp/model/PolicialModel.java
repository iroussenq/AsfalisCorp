package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
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
public class PolicialModel {
    private UUID id;

    @NotNull
    @NotBlank
    @Length(min = 2,max = 30)
    private String nome;
    @NotNull(message = "A data de nascimento não pode ser nula")
    private LocalDate dataDeNascimento;
    
    @NotNull
    private String cpf;
    @NotNull
    private String patente;
    private Long idade;
    private Boolean documentoValido;

    public PolicialModel(Policial policial) {
        this.id = policial.getId();
        this.nome = policial.getNome();
        this.dataDeNascimento = policial.getDataDeNascimento();
        this.cpf = policial.getCpf();
        this.idade = policial.getIdade();
        this.patente = policial.getPatente();
        this.documentoValido = policial.getDocumentoValido();
    }
    
}
