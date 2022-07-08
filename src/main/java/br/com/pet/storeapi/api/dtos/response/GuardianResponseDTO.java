package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

@Data
public class GuardianResponseDTO {

    private String name;
    private String email;
    private String phone;
    private String document;
}
