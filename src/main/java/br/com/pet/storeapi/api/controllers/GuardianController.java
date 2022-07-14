package br.com.pet.storeapi.api.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pet.storeapi.api.dtos.request.GuardianRequestDTO;
import br.com.pet.storeapi.api.dtos.response.GuardianResponseDTO;
import br.com.pet.storeapi.api.dtos.response.PetResponseDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import br.com.pet.storeapi.api.mappers.AddressMapper;
import br.com.pet.storeapi.api.mappers.GuardianMapper;
import br.com.pet.storeapi.api.mappers.PetMapper;
import br.com.pet.storeapi.api.mappers.ScheduleMapper;
import br.com.pet.storeapi.api.mappers.UserMapper;
import br.com.pet.storeapi.api.swagger.GuardianApi;
import br.com.pet.storeapi.domain.entities.Address;
import br.com.pet.storeapi.domain.entities.Guardian;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.GuardianService;
import br.com.pet.storeapi.domain.services.PetService;
import br.com.pet.storeapi.domain.services.ScheduleService;
import lombok.AllArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/guardians")
public class GuardianController implements GuardianApi {

  private final GuardianService guardianService;
  private final PetService petService;
  private final ScheduleService scheduleService;
  private final UserMapper userMapper;
  private final GuardianMapper guardianMapper;
  private final PetMapper petMapper;
  private final AddressMapper addressMapper;
  private final ScheduleMapper scheduleMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GuardianResponseDTO createGuardian(@RequestBody @Valid GuardianRequestDTO guardianRequestDTO) {
    Guardian newGuardian = guardianMapper.toEntity(guardianRequestDTO);
    User newUser = userMapper.toEntityFromGuardian(guardianRequestDTO);
    Address newAddress = addressMapper.toEntity(guardianRequestDTO.getAddress());

    return guardianMapper.toDto(guardianService.createGuardian(newUser, newGuardian, newAddress));
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Page<GuardianResponseDTO> listGuardians(
      @And({
          @Spec(path = "name", spec = Like.class),
          @Spec(path = "phone", spec = Like.class),
          @Spec(path = "document", spec = Like.class)
      }) Specification<Guardian> guardianSpec,
      @PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
    return guardianService.listGuardiansByPage(guardianSpec, pageable).map(guardianMapper::toDto);
  }

  @GetMapping("/{guardianId}/pets")
  @ResponseStatus(HttpStatus.OK)
  public Page<PetResponseDTO> listGuardianPets(
      @AuthenticationPrincipal User userDetails,
      @PathVariable UUID guardianId,
      @PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
    return petService.listGuardianPetsByPage(guardianId, pageable, userDetails).map(petMapper::toDto);
  }

  @GetMapping("/{guardianId}/schedules")
  @ResponseStatus(HttpStatus.OK)
  public Page<ScheduleResponseDTO> listGuardianSchedules(
      @AuthenticationPrincipal User userDetails,
      @PathVariable UUID guardianId,
      @PageableDefault(sort = "scheduleTime", direction = Sort.Direction.ASC) Pageable pageable) {
    return scheduleService.listGuardianSchedulesByPage(guardianId, pageable, userDetails).map(scheduleMapper::toDto);
  }
}
