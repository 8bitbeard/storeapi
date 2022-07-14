package br.com.pet.storeapi.api.swagger;

import br.com.pet.storeapi.api.dtos.request.LoginRequestDTO;
import br.com.pet.storeapi.api.dtos.response.LoginResponseDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication")
public interface AuthenticationApi {

  @Operation(summary = "Log in the user to the application", description = "Log in the user to the application")
  @SecurityRequirements(value = {})
  public LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

  @Operation(summary = "Returns the information from the logged in user", description = "This action can only be performed by a logged in user")
  @Parameter(name = "userDetails", hidden = true)
  public UserResponseDTO sessionUser(User userDetails);
}
