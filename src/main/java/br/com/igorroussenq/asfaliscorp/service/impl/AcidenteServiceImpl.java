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
    private CondutorServiceImpl condutorService;

    @Autowired
    private PolicialServiceImpl policialService;

    @Autowired
    private RodoviaServiceImpl rodoviaService;
    @Autowired
    private VeiculoServiceImpl veiculoService;

    @Override
    public List<AcidenteModel> consultar() {
        return acidenteRepository.findAll().stream().map(AcidenteModel::new).toList();
    }

    @Override
    public AcidenteModel remover(UUID id) {
        Acidente acidente = this.buscarPorId(id);
        acidenteRepository.delete(acidente);
        return new AcidenteModel(acidente);
    }

    @Override
    public AcidenteModel consultar(UUID id) {
        return new AcidenteModel(this.buscarPorId(id));
    }

    @Override
    public AcidenteModel cadastrar(AcidenteModel model) {
        var condutor = condutorService.consultaPorCondutor(model.getCondutor().getId());
        var policial = policialService.consultaPorPolicial(model.getPolicial().getId());
        var rodovia = rodoviaService.consultaPorRodovia(model.getRodovia().getId());
        var veiculo = veiculoService.consultaPorVeiculo(model.getVeiculo().getId());
        var dataDoAcidente = model.getDataDoAcidente();
        var relatorio = model.getRelatorio();
        var casualidades = model.getCasualidades();

        var acidente = new Acidente(condutor,policial, rodovia, veiculo, dataDoAcidente, relatorio, casualidades);
        Integer novasCasualidades = rodovia.getMortes() + casualidades;
        rodovia.editar(rodovia.getNome(), rodovia.getCep(), novasCasualidades);
        return new AcidenteModel(acidenteRepository.save(acidente));
    }

    private Acidente buscarPorId(UUID id){
        return this.acidenteRepository.findById(id).orElseThrow(NaoExisteException::new);
    }

}
