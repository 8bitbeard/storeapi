package br.com.pet.storeapi.api.dtos.request;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PetRequestDTO {

  @NotBlank
  @Size(min = 3)
  private String name;

  @NotNull private OffsetDateTime birthDate;

  @NotBlank private String breed;

  @NotBlank private String specie;
}
