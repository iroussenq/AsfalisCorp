package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.VeiculoModel;
import br.com.igorroussenq.asfaliscorp.repository.VeiculoRepository;
import br.com.igorroussenq.asfaliscorp.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    @Override
    public List<Veiculo> consultar() {
        return veiculoRepository.getAll();
    }

    @Override
    public Veiculo consultarUm(UUID id) {
        return veiculoRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Veiculo cadastrar(VeiculoModel model) {
        Veiculo veiculo = new Veiculo(model.getNome(), model.getPlaca(), model.getAno());
        veiculoRepository.putOne(veiculo);
        return veiculo;
    }

    @Override
    public Veiculo alterar(UUID id, VeiculoModel model) {
        return null;
    }

    @Override
    public Veiculo remover(UUID id) {
        return null;
    }
}
