package br.com.igorroussenq.asfaliscorp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Entity
@NoArgsConstructor
@Table(name = "acidente")
public class Acidente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",insertable = false,updatable = false,nullable = false,unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "rodovia_id",referencedColumnName = "id")
    private Rodovia rodovia;

    @ManyToOne
    @JoinColumn(name = "veiculo_id",referencedColumnName = "id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "policial_id",referencedColumnName = "id")
    private Policial policial;

    @ManyToOne
    @JoinColumn(name = "condutor_id",referencedColumnName = "id")
    private Condutor condutor;

    @Column(name = "data_do_acidente")
    private LocalDate dataDoAcidente;

    private String relatorio;

    private Integer casualidades;

    public Acidente(final Condutor condutor,final Policial policial,final Rodovia rodovia, final Veiculo veiculo, final LocalDate dataDoAcidente, final String relatorio,final Integer casualidades){
        this.id = UUID.randomUUID();
        this.rodovia = rodovia;
        this.condutor = condutor;
        this.policial = policial;
        this.veiculo = veiculo;
        this.dataDoAcidente = dataDoAcidente;
        this.relatorio = relatorio;
        this.casualidades = casualidades;
    }

}