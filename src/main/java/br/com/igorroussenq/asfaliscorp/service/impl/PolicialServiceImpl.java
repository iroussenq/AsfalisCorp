package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.PolicialModel;
import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;
import br.com.igorroussenq.asfaliscorp.repository.PolicialRepository;
import br.com.igorroussenq.asfaliscorp.service.PolicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PolicialServiceImpl implements PolicialService {
    
    @Autowired
    private PolicialRepository policialRepository;

    @Override
    public List<PolicialModel> consultar() {
        return policialRepository.findAll().stream().map(PolicialModel::new).collect(Collectors.toList());
    }

    @Override
    public PolicialModel consultar(UUID id) {
        return new PolicialModel(this.buscarPorId(id));
    }

    @Override
    public PolicialModel cadastrar(PolicialModel model) {
        Policial policial = new Policial(model);
        return new PolicialModel(policialRepository.save(policial));
    }

    @Override
    public PolicialModel alterar(PolicialModel model) {
        Policial policial = this.buscarPorId(model.getId());
        policial.editar(model.getNome(), model.getCpf(), model.getDataDeNascimento(), model.getPatente());
        return new PolicialModel(this.policialRepository.save(policial));
    }

    @Override
    public PolicialModel remover(UUID id) {
        Policial policial = this.buscarPorId(id);
        policialRepository.delete(policial);
        return new PolicialModel(policial);
    }

    private Policial buscarPorId(UUID id) {
        return this.policialRepository.findById(id).orElseThrow(NaoExisteException::new);
    }

    protected Policial consultaPorPolicial(UUID id){
        return this.buscarPorId(id);
    }

}
