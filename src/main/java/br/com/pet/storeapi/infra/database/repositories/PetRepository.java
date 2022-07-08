package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {
}
