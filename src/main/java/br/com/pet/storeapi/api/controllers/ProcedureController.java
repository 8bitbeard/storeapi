package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.ProcedureRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ProcedureResponseDTO;
import br.com.pet.storeapi.api.mappers.ProcedureMapper;
import br.com.pet.storeapi.domain.entities.Procedure;
import br.com.pet.storeapi.domain.services.ProcedureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/procedures")
public class ProcedureController {

    private final ProcedureMapper procedureMapper;
    private final ProcedureService procedureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProcedureResponseDTO createProcedure(@RequestBody @Valid ProcedureRequestDTO procedureRequestDTO) {
        Procedure procedure = procedureMapper.toEntity(procedureRequestDTO);
        Procedure newProcedure = procedureService.createProcedure(procedure);

        return procedureMapper.toDto(newProcedure);
    }
}
