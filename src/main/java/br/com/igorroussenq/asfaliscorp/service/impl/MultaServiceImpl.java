package br.com.igorroussenq.asfaliscorp.service.impl;

import br.com.igorroussenq.asfaliscorp.domain.Multa;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.model.MultaModel;
import br.com.igorroussenq.asfaliscorp.repository.MultaRepository;
import br.com.igorroussenq.asfaliscorp.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Service
public class MultaServiceImpl implements MultaService {

    @Autowired
    private MultaRepository multaRepository;


    @Override
    public List<Multa> consultar() {
        return multaRepository.getAll();
    }

    @Override
    public Multa consultarUm(UUID id) {
        return multaRepository.getOne(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Multa cadastrar(MultaModel model) {
        Multa multa = new Multa(model.getCondicaoDaMulta(),model.getValorDaMulta());
        multaRepository.putOne(multa);
        return multa;
    }

    @Override
    public Multa remover(UUID id) {
        return null;
    }
}
