package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.AddressRequestDTO;
import br.com.pet.storeapi.domain.entities.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapper {

    private final ModelMapper modelMapper;

    public Address toEntity(AddressRequestDTO addressRequestDTO) {
        return modelMapper.map(addressRequestDTO, Address.class);
    }
}
