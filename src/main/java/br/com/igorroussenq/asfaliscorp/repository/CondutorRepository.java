package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Acidente;
import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import br.com.igorroussenq.asfaliscorp.model.CondutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, UUID> {

    //Native Query
    @Query(value = "SELECT * FROM condutor WHERE status_condutor = 'EMBRIAGADO'", nativeQuery = true)
    List<Condutor> buscaCondutoresEmbriagados();

}
