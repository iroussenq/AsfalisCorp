package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Policial;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PolicialRepository {
    List<Policial> getAll();
    Optional<Policial> getOne(UUID id);
    void putOne(Policial policial);
    void delete(Policial policial);

}
