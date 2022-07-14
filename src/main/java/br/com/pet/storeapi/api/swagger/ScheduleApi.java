package br.com.pet.storeapi.api.swagger;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pet.storeapi.api.dtos.request.ScheduleRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Schedules")
public interface ScheduleApi {

  @Operation(summary = "Create a new appointment for a pet", description = "Create a new appointment for a pet from a guardian. This can only be performed by an logged in guardian.")
  public ScheduleResponseDTO createSchedule(ScheduleRequestDTO scheduleRequestDTO);

  @Operation(summary = "List all active appointments", description = "List all active appointments. This can only be performed by a logged in ADMIN user.")
  public Page<ScheduleResponseDTO> listSchedules(@ParameterObject Pageable pageable);
}
