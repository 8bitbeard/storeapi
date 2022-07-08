package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.exceptions.PetNotFoundException;
import br.com.pet.storeapi.api.exceptions.ProcedureNotFoundException;
import br.com.pet.storeapi.api.exceptions.UserNotFoundException;
import br.com.pet.storeapi.domain.entities.*;
import br.com.pet.storeapi.infra.database.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final GuardianRepository guardianRepository;
    private final PetRepository petRepository;
    private final ProcedureRepository procedureRepository;
    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(String userEmail, OffsetDateTime scheduleTime, UUID petId, UUID procedureId) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
        Guardian guardian = guardianRepository.findByUserId(user.getId()).orElseThrow(UserNotFoundException::new);
        Pet pet = petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
        Procedure procedure = procedureRepository.findById(procedureId).orElseThrow(ProcedureNotFoundException::new);

        Schedule schedule = new Schedule();
        schedule.setGuardian(guardian);
        schedule.setPet(pet);
        schedule.setProcedure(procedure);
        schedule.setScheduleTime(scheduleTime);

        return scheduleRepository.save(schedule);
    }
}
