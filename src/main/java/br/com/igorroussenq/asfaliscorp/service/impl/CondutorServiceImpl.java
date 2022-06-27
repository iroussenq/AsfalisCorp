package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import br.com.igorroussenq.asfaliscorp.repository.CondutorRepository;
import br.com.igorroussenq.asfaliscorp.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CondutorServiceImpl implements CondutorService {

    @Autowired
    CondutorRepository condutorRepository;

    @Override
    public List<Condutor> consultar() {
        return condutorRepository.getAll();
    }

    @Override
    public Condutor consultarUm(UUID id) {
        return condutorRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Condutor cadastrar(CondutorModel model) {
        Condutor condutor = new Condutor(model.getNome(),  model.getDataDeNascimento(), model.getCpf(), model.getStatusCondutor());
        condutorRepository.putOne(condutor);
        return condutor;
    }

    @Override
    public Condutor alterar(UUID id, CondutorModel model) {
        Condutor condutor = this.consultarUm(id);
        condutor.editar(model.getNome(), model.getDataDeNascimento(),model.getCpf(), model.getStatusCondutor());
        return condutor;
    }

    @Override
    public Condutor remover(UUID id) {
        Condutor condutor = this.consultarUm(id);
        condutorRepository.delete(condutor);
        return condutor;
    }
}
