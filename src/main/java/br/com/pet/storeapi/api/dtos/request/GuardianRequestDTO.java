package br.com.pet.storeapi.api.dtos.request;

import br.com.pet.storeapi.domain.entities.Address;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GuardianRequestDTO {

    @NotBlank
    @Size(min = 4, max = 30)
    private String name;

    @Email(message = "The e-mail informed is invalid!")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 8)
    private String password;

    @NotBlank
    private String phone;

    @CPF(message = "The document informed is invalid!")
    @NotBlank
    private String document;

    @Valid
    private AddressRequestDTO address;
}
