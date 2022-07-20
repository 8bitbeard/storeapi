package br.com.pet.storeapi.api.dtos.response;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class UserResponseDTO {

  private UUID id;
  private String email;
  private List<RoleResponseDTO> roles;
}
