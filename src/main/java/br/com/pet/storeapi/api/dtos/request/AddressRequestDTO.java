package br.com.pet.storeapi.api.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddressRequestDTO {

    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;
}
