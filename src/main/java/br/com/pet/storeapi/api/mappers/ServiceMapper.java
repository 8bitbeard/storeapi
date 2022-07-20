package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.ServiceRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ServiceResponseDTO;
import br.com.pet.storeapi.domain.entities.Service;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ServiceMapper {

  private final ModelMapper modelMapper;

  public Service toEntity(ServiceRequestDTO serviceRequestDTO) {
    return modelMapper.map(serviceRequestDTO, Service.class);
  }

  public ServiceResponseDTO toDto(Service service) {
    return modelMapper.map(service, ServiceResponseDTO.class);
  }
}
