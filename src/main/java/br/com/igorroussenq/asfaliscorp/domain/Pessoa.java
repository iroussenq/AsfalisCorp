package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.helper.StringUtils;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
public abstract class Pessoa {

    private UUID id;
    private String nome;
    private String cpf;
    private LocalDateTime dataDeNascimento;

    protected Pessoa(final String nome,final String cpf,final LocalDateTime dataDeNascimento){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = StringUtils.extractNumbers(cpf);
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        if (this.cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }

}
