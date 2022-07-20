package br.com.pet.storeapi.api.dtos.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ServiceResponseDTO {
  private UUID id;
  private String description;
  private BigDecimal value;
}
