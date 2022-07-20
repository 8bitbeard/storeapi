package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.LoginRequestDTO;
import br.com.pet.storeapi.api.dtos.response.LoginResponseDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.api.mappers.UserMapper;
import br.com.pet.storeapi.api.swagger.AuthenticationApi;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.domain.services.AuthenticationService;
import br.com.pet.storeapi.domain.services.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthenticationController implements AuthenticationApi {

  private final AuthenticationService authenticationService;
  private final UserService userService;
  private final UserMapper userMapper;

  @PostMapping("/login")
  @ResponseStatus(HttpStatus.CREATED)
  public LoginResponseDTO login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {

    Authentication authenticationToken =
        new UsernamePasswordAuthenticationToken(
            loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

    String accessToken = authenticationService.authenticate(authenticationToken);

    LoginResponseDTO tokenResponse = new LoginResponseDTO("Bearer", accessToken);

    return tokenResponse;
  }

  @GetMapping("/me")
  @ResponseStatus(HttpStatus.OK)
  public UserResponseDTO sessionUser(@AuthenticationPrincipal User userDetails) {
    String userEmail = userDetails.getEmail();
    User user = userService.findUserByEmail(userEmail);

    return userMapper.toDto(user);
  }
}
