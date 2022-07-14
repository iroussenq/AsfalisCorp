package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.helper.StringUtils;
import br.com.igorroussenq.asfaliscorp.model.PolicialModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "policial")
@Getter
@NoArgsConstructor
public class Policial extends Pessoa{

    private String patente;

    public Policial(String nome, String cpf, LocalDate dataDeNascimento, String patente) {
        super(nome, cpf, dataDeNascimento);
        this.patente = patente;
    }

    public Policial(PolicialModel model) {
        super(model.getNome(),model.getCpf(), model.getDataDeNascimento());
        this.patente = model.getPatente();
    }

    public Policial editar(final String nome,final String cpf,final LocalDate dataDeNascimento, final String patente) {
        super.editar(nome,cpf,dataDeNascimento);
        this.patente = patente;
        return this;
    }
}