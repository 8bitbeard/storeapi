package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.util.UUID;

@Data
public class GuardianResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String document;
}
