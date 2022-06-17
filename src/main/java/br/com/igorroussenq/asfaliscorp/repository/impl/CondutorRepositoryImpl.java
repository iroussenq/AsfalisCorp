package br.com.igorroussenq.asfaliscorp.repository.impl;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.repository.CondutorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CondutorRepositoryImpl implements CondutorRepository {

    private static final List<Condutor> LIST = new ArrayList<>();

    @Override
    public List<Condutor> getAll() {return LIST;}

    @Override
    public Optional<Condutor> getOne(UUID id) {
        return LIST.stream().filter(condutor -> id.equals(condutor.getId())).findFirst();
    }

    @Override
    public void putOne(Condutor condutor) {
        LIST.add(condutor);
    }

    @Override
    public void delete(Condutor condutor) {
        LIST.remove(condutor);
    }
}
