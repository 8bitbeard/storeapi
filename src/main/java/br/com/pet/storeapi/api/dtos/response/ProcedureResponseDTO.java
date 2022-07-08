package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProcedureResponseDTO {
    private UUID id;
    private String description;
    private BigDecimal value;
}
