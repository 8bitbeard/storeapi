package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.UserRequestDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.api.mappers.UserMapper;
import br.com.pet.storeapi.api.swagger.UserApi;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.UserService;
import lombok.AllArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
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

@AllArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController implements UserApi {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        User newUserData = userMapper.toEntity(userRequestDTO);

        return userMapper.toDto(userService.createUser(newUserData));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<UserResponseDTO> listUsers(
            @And({
                    @Spec(path = "userId", spec = Equal.class),
                    @Spec(path = "email", spec = Like.class)
            }) Specification<User> userSpec,
            @PageableDefault(sort = "email", direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.listUsersByPage(userSpec, pageable).map(userMapper::toDto);
    }
}
