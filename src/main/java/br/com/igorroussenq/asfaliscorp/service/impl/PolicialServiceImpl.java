package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Multa;
import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.PolicialModel;
import br.com.igorroussenq.asfaliscorp.repository.PolicialRepository;
import br.com.igorroussenq.asfaliscorp.service.PolicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class PolicialServiceImpl implements PolicialService {
    
    @Autowired
    private PolicialRepository policialRepository;

    @Override
    public List<Policial> consultar() {
        return policialRepository.getAll();
    }

    @Override
    public Policial consultarUm(UUID id) {
        return policialRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Policial cadastrar(PolicialModel model) {
        Policial policial = new Policial(model.getNome(), model.getCpf(), model.getDataDeNascimento(),model.getPatente());
        policialRepository.putOne(policial);
        return policial;
    }

    @Override
    public Policial alterar(UUID id, PolicialModel model) {
        Policial policial = this.consultarUm(id);
        policial.editar(model.getNome(), model.getCpf(), model.getDataDeNascimento(), model.getPatente());
        return policial;
    }

    @Override
    public Policial remover(UUID id) {
        Policial policial = this.consultarUm(id);
        policialRepository.delete(policial);
        return policial;
    }
}
