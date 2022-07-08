package br.com.pet.storeapi.config;

import br.com.pet.storeapi.api.dtos.response.GuardianResponseDTO;
import br.com.pet.storeapi.domain.entities.Guardian;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Guardian, GuardianResponseDTO> guardianPropertyMapper = modelMapper.createTypeMap(Guardian.class, GuardianResponseDTO.class);
        guardianPropertyMapper.addMapping(src -> src.getUser().getEmail(), GuardianResponseDTO::setEmail);

        return modelMapper;
    }
}
