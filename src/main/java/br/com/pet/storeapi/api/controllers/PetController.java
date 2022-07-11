package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.PetRequestDTO;
import br.com.pet.storeapi.api.dtos.response.PetResponseDTO;
import br.com.pet.storeapi.api.dtos.response.PetWithGuardianResponseDTO;
import br.com.pet.storeapi.api.mappers.PetMapper;
import br.com.pet.storeapi.domain.entities.Pet;
import br.com.pet.storeapi.domain.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pets")
public class PetController {

    private final PetMapper petMapper;
    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetResponseDTO createPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Pet newPet = petMapper.toEntity(petRequestDTO);

        return petMapper.toDto(petService.createPet(newPet, userEmail));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PetWithGuardianResponseDTO> listPets(
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return petService.listPetsByPage(pageable).map(petMapper::toDtoWithUser);
    }
}
