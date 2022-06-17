package br.com.igorroussenq.asfaliscorp.repository.impl;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.repository.RodoviaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RodoviaRepositoryImpl implements RodoviaRepository {

    private static final List<Rodovia> LIST = new ArrayList<>();

    @Override
    public List<Rodovia> getAll() {return LIST;}

    @Override
    public Optional<Rodovia> getOne(UUID id) {
        return LIST.stream().filter(rodovia -> id.equals(rodovia.getId())).findFirst();
    }

    @Override
    public void putOne(Rodovia rodovia) {
        LIST.add(rodovia);
    }

    @Override
    public void delete(Rodovia rodovia) {
        LIST.remove(rodovia);
    }
}
