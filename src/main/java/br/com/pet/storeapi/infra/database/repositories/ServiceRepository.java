package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Service;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository
    extends JpaRepository<Service, UUID>, JpaSpecificationExecutor<Service> {

  Optional<Service> findByDescription(String description);
}
