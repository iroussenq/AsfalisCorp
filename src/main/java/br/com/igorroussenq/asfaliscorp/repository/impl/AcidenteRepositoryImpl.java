package br.com.igorroussenq.asfaliscorp.repository.impl;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.repository.AcidenteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AcidenteRepositoryImpl implements AcidenteRepository {

    private static final List<Acidente> LIST = new ArrayList<>();

    @Override
    public List<Acidente> getAll() {return LIST;}

    @Override
    public Optional<Acidente> getOne(UUID id) {
        return LIST.stream().filter(acidente -> id.equals(acidente.getId())).findFirst();
    }

    @Override
    public void putOne(Acidente acidente) {
        LIST.add(acidente);
    }

    @Override
    public void delete(Acidente acidente) {
        LIST.remove(acidente);
    }
}
