package br.com.pet.storeapi.api.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ServiceRequestDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal value;
}
