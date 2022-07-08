package br.com.pet.storeapi.api.dtos.response;

import br.com.pet.storeapi.domain.entities.Role;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private List<Role> authorities;

}
