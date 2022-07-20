package br.com.pet.storeapi.api.dtos.response;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class ScheduleResponseDTO {

  private GuardianResponseDTO guardian;
  private PetResponseDTO pet;
  private ServiceResponseDTO service;
  private OffsetDateTime scheduleTime;
}
