package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.GuardianRequestDTO;
import br.com.pet.storeapi.api.dtos.response.GuardianResponseDTO;
import br.com.pet.storeapi.api.dtos.response.GuardiansResponseDTO;
import br.com.pet.storeapi.api.mappers.AddressMapper;
import br.com.pet.storeapi.api.mappers.GuardianMapper;
import br.com.pet.storeapi.api.mappers.UserMapper;
import br.com.pet.storeapi.domain.entities.Address;
import br.com.pet.storeapi.domain.entities.Guardian;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.GuardianService;
import br.com.pet.storeapi.domain.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/guardians")
public class GuardianController {

    private final GuardianService guardianService;
    private final UserMapper userMapper;
    private final GuardianMapper guardianMapper;
    private final AddressMapper addressMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuardianResponseDTO createGuardian(@RequestBody @Valid GuardianRequestDTO guardianRequestDTO) {
        Guardian newGuardian = guardianMapper.toEntity(guardianRequestDTO);
        User newUser = userMapper.toEntityFromGuardian(guardianRequestDTO);
        Address newAddress = addressMapper.toEntity(guardianRequestDTO.getAddress());

        return guardianMapper.toDto(guardianService.createGuardian(newUser, newGuardian, newAddress));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GuardiansResponseDTO listGuardians() {
        GuardiansResponseDTO guardians = new GuardiansResponseDTO();
        guardianService.listGuardians().forEach(guardian -> guardians.addGuardian(guardianMapper.toDto(guardian)));

        return guardians;
    }
}
