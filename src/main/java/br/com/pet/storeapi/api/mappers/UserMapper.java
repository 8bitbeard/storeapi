package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.GuardianRequestDTO;
import br.com.pet.storeapi.api.dtos.request.UserRequestDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.domain.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

  private final ModelMapper modelMapper;

  public User toEntity(UserRequestDTO userRequestDTO) {
    return modelMapper.map(userRequestDTO, User.class);
  }

  public User toEntityFromGuardian(GuardianRequestDTO guardianRequestDTO) {
    return modelMapper.map(guardianRequestDTO, User.class);
  }

  public UserResponseDTO toDto(User user) {
    return modelMapper.map(user, UserResponseDTO.class);
  }
}
