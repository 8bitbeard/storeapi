package br.com.pet.storeapi.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestExceptionResponseDTO {
    private String status;
    private String message;
}
