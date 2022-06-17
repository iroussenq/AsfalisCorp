package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RodoviaRepository {
    List<Rodovia> getAll();
    Optional<Rodovia> getOne(UUID id);
    void putOne(Rodovia rodovia);
    void delete(Rodovia rodovia);
}
