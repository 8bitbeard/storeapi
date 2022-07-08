package br.com.pet.storeapi.api.dtos.request;

import br.com.pet.storeapi.domain.entities.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UserRequestDTO {

    @NotBlank
    @Email(message = "The informed e-mail is not valid!")
    private String email;

    @NotBlank
    @Size(min = 6, max = 10)
    private String password;

    @NotNull
    private List<Role> authorities;
}
