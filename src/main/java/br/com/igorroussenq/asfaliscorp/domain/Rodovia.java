package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "rodovia")
public class Rodovia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",insertable = false,updatable = false,nullable = false,unique = true)
    private UUID id;
    private String nome;
    private String cep;
    private Integer mortes;

    public Rodovia(String nome, String cep, Integer mortes){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cep = cep;
        this.mortes = mortes;
    }

    public Rodovia(RodoviaModel model) {
        this.nome = model.getNome();
        this.cep = model.getCep();
        this.mortes = model.getMortes();
    }

    public Rodovia editar(String nome, String cep, Integer mortes){
        this.nome = nome;
        this.cep = cep;
        this.mortes = mortes;
        return this;
    }

    public String getCep() {
        if (this.cep.length() == 8) {
            return cep.replaceAll("/^[0-9]{8}$/", "$1-$2");
        }
        return cep;
    }
}
