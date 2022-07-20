package br.com.pet.storeapi.api.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

  public String tokenType;
  public String accessToken;
}
