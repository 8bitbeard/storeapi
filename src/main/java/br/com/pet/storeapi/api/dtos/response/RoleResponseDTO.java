package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleResponseDTO {

    private UUID id;
    private String name;
}
