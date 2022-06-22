package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
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

@Service
public class RodoviaServiceImpl implements RodoviaService {

    @Autowired
    private RodoviaRepository rodoviaRepository;


    @Override
    public List<Rodovia> consultar() {
        return rodoviaRepository.getAll();
    }

    @Override
    public Rodovia consultarUm(UUID id) {
        return rodoviaRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Rodovia cadastrar(RodoviaModel model) {
        Rodovia rodovia = new Rodovia(model.getNome(), model.getKm(), model.getMortes());
        rodoviaRepository.putOne(rodovia);
        return rodovia;
    }

    @Override
    public Rodovia alterar(UUID id, RodoviaModel model) {
        Rodovia rodovia = this.consultarUm(id);
        rodovia.editar(model.getNome(), model.getKm(), model.getMortes());
        return rodovia;
    }

    @Override
    public Rodovia remover(UUID id) {
        Rodovia rodovia = this.consultarUm(id);
        rodoviaRepository.delete(rodovia);
        return rodovia;
    }
}
