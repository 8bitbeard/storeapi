package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.LoginRequestDTO;
import br.com.pet.storeapi.api.dtos.response.LoginResponseDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.api.mappers.UserMapper;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.AuthenticationService;
import br.com.pet.storeapi.domain.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthenticationController {


    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDTO login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getEmail(),
                loginRequestDTO.getPassword());

        String accessToken = authenticationService.authenticate(authenticationToken);

        LoginResponseDTO tokenResponse = new LoginResponseDTO("Bearer", accessToken);

        return tokenResponse;
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO sessionUser(@AuthenticationPrincipal User userDetails) {
        User user = userService.findUserByEmail(userDetails);

        return userMapper.toDto(user);
    }
}
