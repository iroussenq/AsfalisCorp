package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoRepository {
    List<Veiculo> getAll();
    Optional<Veiculo> getOne(UUID id);
    void putOne(Veiculo Veiculo);
    void delete(Veiculo Veiculo);
}
