package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CondutorRepository {
    List<Condutor> getAll();
    Optional<Condutor> getOne(UUID id);
    void putOne(Condutor Condutor);
    void delete(Condutor Condutor);
}
