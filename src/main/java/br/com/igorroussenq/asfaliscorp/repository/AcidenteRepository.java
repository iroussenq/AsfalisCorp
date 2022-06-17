package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AcidenteRepository {
    List<Acidente> getAll();
    Optional<Acidente> getOne(UUID id);
    void putOne(Acidente acidente);
    void delete(Acidente acidente);
}
