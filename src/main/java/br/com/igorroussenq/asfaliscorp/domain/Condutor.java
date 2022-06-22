package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.enums.EnumStatusCondutor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Condutor extends Pessoa{

    private EnumStatusCondutor statusCondutor;

    public Condutor(final String nome, final String cpf, final LocalDate dataDeNascimento, final EnumStatusCondutor statusCondutor) {
        super(nome, cpf, dataDeNascimento);
        this.statusCondutor = statusCondutor;
    }

    public Condutor editar(final String nome, final String cpf, final LocalDate dataDeNascimento, final EnumStatusCondutor statusCondutor) {
        super.editar(nome, cpf, dataDeNascimento);
        this.statusCondutor = statusCondutor;
        return this;
    }
}
