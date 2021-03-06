package br.com.pet.storeapi.api.dtos.response;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class PetWithGuardianResponseDTO {

  private UUID id;
  private String name;
  private OffsetDateTime birthDate;
  private String breed;
  private String specie;
  private GuardianResponseDTO guardian;
}
