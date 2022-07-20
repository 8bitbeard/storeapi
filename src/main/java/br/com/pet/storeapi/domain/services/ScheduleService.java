package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.exceptions.*;
import br.com.pet.storeapi.domain.entities.*;
import br.com.pet.storeapi.infra.database.repositories.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ScheduleService {

  private final UserRepository userRepository;
  private final GuardianRepository guardianRepository;
  private final PetRepository petRepository;
  private final ServiceRepository serviceRepository;
  private final ScheduleRepository scheduleRepository;

  public Schedule createSchedule(
      String userEmail, OffsetDateTime scheduleTime, UUID petId, UUID serviceId) {
    User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
    Guardian guardian =
        guardianRepository.findByUserId(user.getId()).orElseThrow(UserNotFoundException::new);
    Pet pet = petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    Service service =
        serviceRepository.findById(serviceId).orElseThrow(ServiceNotFoundException::new);

    Schedule schedule = new Schedule();
    schedule.setGuardian(guardian);
    schedule.setPet(pet);
    schedule.setService(service);
    schedule.setScheduleTime(scheduleTime);

    return scheduleRepository.save(schedule);
  }

  public Page<Schedule> listGuardianSchedulesByPage(
      UUID guardianId, Pageable pageable, User userDetails) {
    Guardian guardian =
        guardianRepository.findById(guardianId).orElseThrow(GuardianNotFoundException::new);
    if (!userDetails.isAdmin() && !userDetails.getId().equals(guardian.getUser().getId())) {
      throw new ForbiddenException();
    }
    return scheduleRepository.findByGuardianId(guardianId, pageable);
  }

  public Page<Schedule> listPetSchedulesByPage(UUID petId, Pageable pageable, User userDetails) {
    Pet pet = petRepository.findById(petId).orElseThrow(GuardianNotFoundException::new);
    Guardian guardian =
        guardianRepository
            .findById(pet.getGuardian().getId())
            .orElseThrow(GuardianNotFoundException::new);
    if (!userDetails.isAdmin() && !userDetails.getId().equals(guardian.getUser().getId())) {
      throw new ForbiddenException();
    }
    return scheduleRepository.findByPetId(petId, pageable);
  }

  public Page<Schedule> listSchedulesByPage(Pageable pageable) {
    return scheduleRepository.findAll(pageable);
  }
}
