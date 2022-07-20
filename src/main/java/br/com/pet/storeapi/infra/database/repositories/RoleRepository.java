package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Role;
import br.com.pet.storeapi.domain.entities.RoleEnum;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

  Role findByName(RoleEnum name);
}
