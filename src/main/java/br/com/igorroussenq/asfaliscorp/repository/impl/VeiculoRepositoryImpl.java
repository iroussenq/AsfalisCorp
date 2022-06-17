package br.com.igorroussenq.asfaliscorp.repository.impl;

import br.com.igorroussenq.asfaliscorp.domain.Veiculo;
import br.com.igorroussenq.asfaliscorp.repository.VeiculoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository {

    private static final List<Veiculo> LIST = new ArrayList<>();

    @Override
    public List<Veiculo> getAll() {return LIST;}

    @Override
    public Optional<Veiculo> getOne(UUID id) {
        return LIST.stream().filter(veiculo -> id.equals(veiculo.getId())).findFirst();
    }

    @Override
    public void putOne(Veiculo veiculo) {
        LIST.add(veiculo);
    }

    @Override
    public void delete(Veiculo veiculo) {
        LIST.remove(veiculo);
    }
}
