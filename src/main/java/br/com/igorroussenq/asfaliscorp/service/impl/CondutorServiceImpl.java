package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import br.com.igorroussenq.asfaliscorp.repository.CondutorRepository;
import br.com.igorroussenq.asfaliscorp.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CondutorServiceImpl implements CondutorService {

    @Autowired
    CondutorRepository condutorRepository;

    @Override
    public List<CondutorModel> consultar() {
        return condutorRepository.findAll().stream().map(CondutorModel::new).collect(Collectors.toList());
    }

    @Override
    public CondutorModel consultar(UUID id) {
        return new CondutorModel(this.buscarPorId(id));
    }

    @Override
    public CondutorModel cadastrar(CondutorModel model) {
        Condutor condutor = new Condutor(model);
        return new CondutorModel(condutorRepository.save(condutor));
    }

    @Override
    public CondutorModel alterar(CondutorModel model) {
        Condutor condutor = this.buscarPorId(model.getId());
        condutor.editar(model.getNome(), model.getDataDeNascimento(), model.getCpf(), model.getStatusCondutor()); //fixme
        return new CondutorModel(this.condutorRepository.save(condutor));
    }

    @Override
    public CondutorModel remover(UUID id) {
        Condutor condutor = this.buscarPorId(id);
        condutorRepository.delete(condutor);
        return new CondutorModel(condutor);
    }

    @Override
    public List<CondutorModel> buscaCondutoresEmbriagados() {
        return condutorRepository.buscaCondutoresEmbriagados().stream().map(CondutorModel::new).collect(Collectors.toList());
    }

    private Condutor buscarPorId(UUID id) {
        return this.condutorRepository.findById(id).orElseThrow(NaoExisteException::new);
    }

    protected Condutor consultaPorCondutor(UUID id){
        return this.buscarPorId(id);
    }
}
