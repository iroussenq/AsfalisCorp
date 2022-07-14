package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Rodovia;
import br.com.igorroussenq.asfaliscorp.model.RodoviaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RodoviaRepository extends JpaRepository<Rodovia,UUID> {
    @Query(value = "SELECT Rodovia FROM Rodovia WHERE (mortes > 5)")
    List<Rodovia> buscaRodoviaComMaisQueCincoMortes();

}


