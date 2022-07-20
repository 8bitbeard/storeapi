package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Pet;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PetRepository extends JpaRepository<Pet, UUID>, JpaSpecificationExecutor<Pet> {
  Page<Pet> findByGuardianId(UUID guardianId, Pageable pageable);
}
