package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, UUID> {

}
