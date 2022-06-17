package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.enums.EnumStatusCondutor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Condutor extends Pessoa{

    private EnumStatusCondutor statusCondutor;

    protected Condutor(final String nome, final String cpf, final LocalDateTime dataDeNascimento, final EnumStatusCondutor statusCondutor) {
        super(nome, cpf, dataDeNascimento);
        this.statusCondutor = statusCondutor;
    }
}
