package br.com.pet.storeapi.api.dtos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

  @NotBlank
  @Email(message = "The informed e-mail is not valid!")
  private String email;

  @NotBlank
  @Size(min = 6, max = 10)
  private String password;
}
