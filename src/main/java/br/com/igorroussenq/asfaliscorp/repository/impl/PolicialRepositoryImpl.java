package br.com.igorroussenq.asfaliscorp.repository.impl;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import br.com.igorroussenq.asfaliscorp.repository.PolicialRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PolicialRepositoryImpl implements PolicialRepository {

    private static final List<Policial> LIST = new ArrayList<>();

    @Override
    public List<Policial> getAll() {return LIST;}

    @Override
    public Optional<Policial> getOne(UUID id) {
        return LIST.stream().filter(policial -> id.equals(policial.getId())).findFirst();
    }

    @Override
    public void putOne(Policial policial) {
        LIST.add(policial);
    }

    @Override
    public void delete(Policial policial) {
        LIST.remove(policial);
    }
}
