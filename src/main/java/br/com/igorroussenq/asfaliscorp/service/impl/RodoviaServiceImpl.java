package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;
import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;
import br.com.igorroussenq.asfaliscorp.repository.RodoviaRepository;
import br.com.igorroussenq.asfaliscorp.repository.VeiculoRepository;
import br.com.igorroussenq.asfaliscorp.service.RodoviaService;
import br.com.igorroussenq.asfaliscorp.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RodoviaServiceImpl implements RodoviaService {

    @Autowired
    private RodoviaRepository rodoviaRepository;

    @Override
    public List<RodoviaModel> consultar() {
        return rodoviaRepository.findAll().stream().map(RodoviaModel::new).collect(Collectors.toList());
    }

    @Override
    public RodoviaModel consultar(UUID id) {
        return new RodoviaModel(this.buscarPorId(id));

    }

    @Override
    public RodoviaModel cadastrar(RodoviaModel model) {
        Rodovia rodovia = new Rodovia(model);
        return new RodoviaModel(this.rodoviaRepository.save(rodovia));
    }

    @Override
    public RodoviaModel alterar(RodoviaModel model) {
        Rodovia rodovia = this.buscarPorId(model.getId());
        rodovia.editar(model.getNome(), model.getCep(), model.getMortes());
        return new RodoviaModel(this.rodoviaRepository.save(rodovia));
    }

    @Override
    public RodoviaModel remover(UUID id) {
        Rodovia rodovia = this.buscarPorId(id);
        rodoviaRepository.delete(rodovia);
        return new RodoviaModel(this.rodoviaRepository.save(rodovia));
    }

    private Rodovia buscarPorId(UUID id) {
        return this.rodoviaRepository.findById(id).orElseThrow(NaoExisteException::new);
    }

    protected Rodovia consultaPorRodovia(UUID id){
        return this.buscarPorId(id);
    }
}
