package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Guardian;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, UUID> {

    Optional<Guardian> findByDocument(String document);
    Optional<Guardian> findByUserId(UUID userId);
    Page<Guardian> findAll(Pageable pageable);
}
