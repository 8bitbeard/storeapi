package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.PetRequestDTO;
import br.com.pet.storeapi.api.dtos.response.PetResponseDTO;
import br.com.pet.storeapi.api.dtos.response.PetWithGuardianResponseDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import br.com.pet.storeapi.api.mappers.PetMapper;
import br.com.pet.storeapi.api.mappers.ScheduleMapper;
import br.com.pet.storeapi.domain.entities.Pet;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.PetService;
import br.com.pet.storeapi.domain.services.ScheduleService;
import lombok.AllArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pets")
public class PetController {

    private final PetMapper petMapper;
    private final ScheduleMapper scheduleMapper;
    private final PetService petService;
    private final ScheduleService scheduleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetResponseDTO createPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Pet newPet = petMapper.toEntity(petRequestDTO);

        return petMapper.toDto(petService.createPet(newPet, userEmail));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<PetWithGuardianResponseDTO> listPets(
            @And({
                    @Spec(path = "name", spec = Like.class),
                    @Spec(path = "breed", spec = Like.class),
                    @Spec(path = "specie", spec = Like.class)
            }) Specification<Pet> petSpec,
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return petService.listPetsByPage(petSpec, pageable).map(petMapper::toDtoWithUser);
    }

    @GetMapping("/{petId}/schedules")
    @ResponseStatus(HttpStatus.OK)
    public Page<ScheduleResponseDTO> listPetSchedules(
            @AuthenticationPrincipal User userDetails,
            @PathVariable UUID petId,
            @PageableDefault(sort = "scheduleTime", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return scheduleService.listPetSchedulesByPage(petId, pageable, userDetails).map(scheduleMapper::toDto);
    }
}
