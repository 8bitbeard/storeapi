package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Procedure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, UUID> {

    Optional<Procedure> findByDescription(String description);
    Page<Procedure> findAll(Pageable pageable);
}
