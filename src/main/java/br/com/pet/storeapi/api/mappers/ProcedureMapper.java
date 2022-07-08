package br.com.pet.storeapi.api.mappers;

import br.com.pet.storeapi.api.dtos.request.ProcedureRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ProcedureResponseDTO;
import br.com.pet.storeapi.domain.entities.Procedure;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProcedureMapper {

    private final ModelMapper modelMapper;

    public Procedure toEntity(ProcedureRequestDTO procedureRequestDTO) {
        return modelMapper.map(procedureRequestDTO, Procedure.class);
    }

    public ProcedureResponseDTO toDto(Procedure procedure) {
        return modelMapper.map(procedure, ProcedureResponseDTO.class);
    }
}
