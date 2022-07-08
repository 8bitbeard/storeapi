package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.LoginRequestDTO;
import br.com.pet.storeapi.api.dtos.response.LoginResponseDTO;
import br.com.pet.storeapi.domain.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthenticationController {


    private final AuthenticationService authenticationService;

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
}
