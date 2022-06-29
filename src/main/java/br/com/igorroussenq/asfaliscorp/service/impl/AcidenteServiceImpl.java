package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.AcidenteModel;
import br.com.igorroussenq.asfaliscorp.repository.AcidenteRepository;
import br.com.igorroussenq.asfaliscorp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AcidenteServiceImpl implements AcidenteService {

    @Autowired
    private AcidenteRepository acidenteRepository;

    @Autowired
    private CondutorService condutorService;

    @Autowired
    private PolicialService policialService;

    @Autowired
    private RodoviaService rodoviaService;
    @Autowired
    private VeiculoService veiculoService;

    @Override
    public List<Acidente> consultar() {
        return acidenteRepository.getAll();
    }

    @Override
    public Acidente remover(UUID id) {
        Acidente acidente = this.consultarUm(id);
        acidenteRepository.delete(acidente);
        return acidente;
    }

    @Override
    public Acidente consultarUm(UUID id) {
        return acidenteRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Acidente cadastrar(AcidenteModel model) {
        var condutor = condutorService.consultarUm(model.getIdCondutor());
        var policial = policialService.consultarUm(model.getIdPolicial());
        var rodovia = rodoviaService.consultarUm(model.getIdRodovia());
        var veiculo = veiculoService.consultarUm(model.getIdVeiculo());
        var dataDoAcidente = model.getDataDoAcidente();
        var relatorio = model.getRelatorio();
        var casualidades = model.getCasualidades();

        var acidente = new Acidente(condutor,policial, rodovia, veiculo, dataDoAcidente, relatorio, casualidades);
        Integer novasCasualidades = rodovia.getMortes() + casualidades;
        rodovia.editar(rodovia.getNome(), rodovia.getKm(), novasCasualidades);

        acidenteRepository.putOne(acidente);
        return acidente;
    }

}
