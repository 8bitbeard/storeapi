package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Schedule;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
  Page<Schedule> findByGuardianId(UUID guardianId, Pageable pageable);

  Page<Schedule> findByPetId(UUID petId, Pageable pageable);
}
