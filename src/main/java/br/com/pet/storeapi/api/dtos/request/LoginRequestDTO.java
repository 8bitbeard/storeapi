package br.com.pet.storeapi.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String password;
}
