package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.enums.EnumStatusCondutor;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "condutor")
@NoArgsConstructor
public class Condutor extends Pessoa{


    @Enumerated(EnumType.STRING)
    @Column(name = "status_condutor")
    private EnumStatusCondutor statusCondutor;

    public Condutor(final String nome,
                    final LocalDate dataDeNascimento,
                    final String cpf,
                    final EnumStatusCondutor statusCondutor) {
        super(nome, cpf, dataDeNascimento);
        this.statusCondutor = statusCondutor;
    }

    public Condutor(CondutorModel model) {
        super(model.getNome(), model.getCpf(), model.getDataDeNascimento());
        this.statusCondutor = model.getStatusCondutor();
    }

    public Condutor editar(final String nome,final LocalDate dataDeNascimento, final String cpf,  final EnumStatusCondutor statusCondutor) {
        super.editar(nome, cpf, dataDeNascimento);
        this.statusCondutor = statusCondutor;
        return this;
    }
}
