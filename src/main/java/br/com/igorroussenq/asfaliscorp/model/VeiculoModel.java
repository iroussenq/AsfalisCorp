package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class VeiculoModel {
    private UUID id;
    private String nome;
    private String placa;
    private Integer ano;

    public VeiculoModel(Veiculo veiculo){
        this.id = veiculo.getId();
        this.nome = veiculo.getNome();
        this.ano = veiculo.getAno();
        this.placa = veiculo.getPlaca();
    }


}