package br.com.pet.storeapi.api.dtos.response;

import java.util.UUID;
import lombok.Data;

@Data
public class RoleResponseDTO {

  private UUID id;
  private String name;
}
