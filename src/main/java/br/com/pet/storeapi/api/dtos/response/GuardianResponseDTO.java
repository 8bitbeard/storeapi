package br.com.pet.storeapi.api.dtos.response;

import java.util.UUID;
import lombok.Data;

@Data
public class GuardianResponseDTO {

  private UUID id;
  private String name;
  private String email;
  private String phone;
  private String document;
}
