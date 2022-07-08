package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
}
