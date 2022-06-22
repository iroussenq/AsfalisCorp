package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.domain.Multa;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.AcidenteModel;
import br.com.igorroussenq.asfaliscorp.model.AdicionarMultaModel;
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
    private MultaService multaService;
    @Autowired
    private RodoviaService rodoviaService;

    @Override
    public List<Acidente> consultar() {
        return acidenteRepository.getAll();
    }

    @Override
    public Acidente consultarUm(UUID id) {
        return acidenteRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Acidente cadastrar(AcidenteModel model) {
        var policial = policialService.consultarUm(model.getIdPolicial());
        var condutor = condutorService.consultarUm(model.getIdCondutor());
        var rodovia = rodoviaService.consultarUm(model.getIdRodovia());
        var acidente = new Acidente(policial, condutor, rodovia);
        acidenteRepository.putOne(acidente);
        return acidente;
    }

    @Override
    public Acidente adicionarMulta(UUID id, AdicionarMultaModel model) {
        Acidente acidente = this.consultarUm(id);
        List<Multa> multas = multaService.consultarTodos(model.getIdsMultas());
        acidente.addMulta(multas);
        return acidente;
    }

}
