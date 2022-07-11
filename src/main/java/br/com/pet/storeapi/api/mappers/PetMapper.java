package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.PetRequestDTO;
import br.com.pet.storeapi.api.dtos.response.PetResponseDTO;
import br.com.pet.storeapi.api.dtos.response.PetWithGuardianResponseDTO;
import br.com.pet.storeapi.domain.entities.Pet;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PetMapper {
    private final ModelMapper modelMapper;

    public Pet toEntity(PetRequestDTO petRequestDTO) {
        return modelMapper.map(petRequestDTO, Pet.class);
    }

    public PetResponseDTO toDto(Pet pet) {
        return modelMapper.map(pet, PetResponseDTO.class);
    }

    public PetWithGuardianResponseDTO toDtoWithUser(Pet pet) {
        return modelMapper.map(pet, PetWithGuardianResponseDTO.class);
    }
}
