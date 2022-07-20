package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Address;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {}
