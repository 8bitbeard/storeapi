package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.UserRequestDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.api.mappers.UserMapper;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        User newUserData = userMapper.toEntity(userRequestDTO);

        return userMapper.toDto(userService.createUser(newUserData));
    }
}
