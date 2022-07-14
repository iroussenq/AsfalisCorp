package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",insertable = false,updatable = false,nullable = false,unique = true)

    private UUID id;
    private String nome;
    private String placa;
    private Integer ano;

    public Veiculo(String nome,String placa,Integer ano){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
    }

    public Veiculo(VeiculoModel model) {
        this.nome = model.getNome();
        this.placa = model.getPlaca();
        this.ano = model.getAno();
    }

    public Veiculo editar(String nome,String placa,Integer ano){
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
        return this;
    }
}