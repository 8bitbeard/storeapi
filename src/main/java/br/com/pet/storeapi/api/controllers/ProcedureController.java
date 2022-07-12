package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.ProcedureRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ProcedureResponseDTO;
import br.com.pet.storeapi.api.mappers.ProcedureMapper;
import br.com.pet.storeapi.domain.entities.Procedure;
import br.com.pet.storeapi.domain.services.ProcedureService;
import lombok.AllArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<ProcedureResponseDTO> listProcedures(
            @And({
                    @Spec(path = "description", spec = Like.class)
            }) Specification<Procedure> procedureSpec,
            @PageableDefault(sort = "description", direction = Sort.Direction.ASC) Pageable pageable) {
        return procedureService.listProceduresByPage(procedureSpec, pageable).map(procedureMapper::toDto);
    }
}
