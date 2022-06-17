package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Multa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MultaRepository {
    List<Multa> getAll();
    Optional<Multa> getOne(UUID id);
    void putOne(Multa multa);
    void delete(Multa multa);
}