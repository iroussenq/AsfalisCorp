package br.com.igorroussenq.asfaliscorp.model;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
public class AcidenteModel {
    private UUID id;
    private CondutorModel condutor;
    private PolicialModel policial;
    private RodoviaModel rodovia;
    private VeiculoModel veiculo;
    private LocalDate dataDoAcidente;
    private String relatorio;
    private Integer casualidades;

    public AcidenteModel(Acidente acidente){
        this.id = acidente.getId();
        this.condutor = Objects.nonNull(acidente.getCondutor()) ? new CondutorModel(acidente.getCondutor()) : new CondutorModel();
        this.policial = Objects.nonNull(acidente.getPolicial()) ? new PolicialModel(acidente.getPolicial()) : new PolicialModel();
        this.rodovia = Objects.nonNull(acidente.getRodovia()) ? new RodoviaModel(acidente.getRodovia()) : new RodoviaModel();
        this.veiculo = Objects.nonNull(acidente.getVeiculo()) ? new VeiculoModel(acidente.getVeiculo()) : new VeiculoModel();
        this.dataDoAcidente = acidente.getDataDoAcidente();
        this.relatorio = acidente.getRelatorio();
        this.casualidades = acidente.getCasualidades();
    }
}
