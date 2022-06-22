package br.com.igorroussenq.asfaliscorp.repository.impl;

import br.com.igorroussenq.asfaliscorp.domain.Multa;
import br.com.igorroussenq.asfaliscorp.exceptions.NaoExisteException;
import br.com.igorroussenq.asfaliscorp.repository.MultaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MultaRepositoryImpl implements MultaRepository {

    private static final List<Multa> LIST = new ArrayList<>();

    @Override
    public List<Multa> getAll() {return LIST;}

    @Override
    public Optional<Multa> getOne(UUID id) {
        return LIST.stream().filter(multa -> id.equals(multa.getId())).findFirst();
    }

    @Override
    public List<Multa> getAllIds(List<UUID> ids) {
        return ids.stream().map(id -> this.getOne(id).orElseThrow(NaoExisteException::new)).toList();
    }

    @Override
    public void putOne(Multa multa) {
        LIST.add(multa);
    }

    @Override
    public void delete(Multa multa) {
        LIST.remove(multa);
    }
}
