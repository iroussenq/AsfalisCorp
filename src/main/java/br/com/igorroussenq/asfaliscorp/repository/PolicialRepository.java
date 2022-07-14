package br.com.igorroussenq.asfaliscorp.repository;

import br.com.igorroussenq.asfaliscorp.domain.Policial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PolicialRepository extends JpaRepository<Policial, UUID> {

}
