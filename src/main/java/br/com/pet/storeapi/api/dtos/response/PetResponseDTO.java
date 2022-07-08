package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class PetResponseDTO {

    private UUID id;
    private String name;
    private OffsetDateTime birthDate;
    private String breed;
    private String specie;
}
