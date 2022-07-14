package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;
import br.com.igorroussenq.asfaliscorp.repository.VeiculoRepository;
import br.com.igorroussenq.asfaliscorp.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    @Override
    public List<VeiculoModel> consultar() {
        return veiculoRepository.findAll().stream().map(VeiculoModel::new).collect(Collectors.toList());
    }

    @Override
    public VeiculoModel consultar(UUID id) {
        return new VeiculoModel(this.buscarPorId(id));
    }

    @Override
    public VeiculoModel cadastrar(VeiculoModel model) {
        Veiculo veiculo = new Veiculo(model);
        return new VeiculoModel(veiculoRepository.save(veiculo));
    }

    @Override
    public VeiculoModel alterar( VeiculoModel model) {
        Veiculo veiculo = this.buscarPorId(model.getId());
        veiculo.editar(model.getNome(), model.getPlaca(), model.getAno());
        return new VeiculoModel(this.veiculoRepository.save(veiculo));
    }

    @Override
    public VeiculoModel remover(UUID id) {
        Veiculo veiculo = this.buscarPorId(id);
        veiculoRepository.delete(veiculo);
        return new VeiculoModel(veiculo);
    }

    private Veiculo buscarPorId(UUID id) {
        return this.veiculoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }

    protected Veiculo consultaPorVeiculo(UUID id){
        return this.buscarPorId(id);
    }
}
