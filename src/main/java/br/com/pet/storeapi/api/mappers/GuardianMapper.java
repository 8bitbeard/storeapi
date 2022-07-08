package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.GuardianRequestDTO;
import br.com.pet.storeapi.api.dtos.request.UserRequestDTO;
import br.com.pet.storeapi.api.dtos.response.GuardianResponseDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.domain.entities.Guardian;
import br.com.pet.storeapi.domain.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuardianMapper {

    private final ModelMapper modelMapper;

    public Guardian toEntity(GuardianRequestDTO guardianRequestDTO) {
        return modelMapper.map(guardianRequestDTO, Guardian.class);
    }

    public GuardianResponseDTO toDto(Guardian guardian) {
        return modelMapper.map(guardian, GuardianResponseDTO.class);
    }
}
