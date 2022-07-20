package br.com.pet.storeapi.api.swagger;

import br.com.pet.storeapi.api.dtos.request.UserRequestDTO;
import br.com.pet.storeapi.api.dtos.response.UserResponseDTO;
import br.com.pet.storeapi.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Users")
public interface UserApi {

  @Operation(
      summary = "Create a new Admin user for the application",
      description =
          "Create a new Admin user for the application. This operation can only be performed by an"
              + " Logged in ADMIN user")
  UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO);

  @Operation(
      summary = "List all users of the application",
      description =
          "List all users of the application. This operation can only be performed by an Logged in"
              + " ADMIN user")
  @Parameter(name = "userSpec", hidden = true)
  @Parameter(
      name = "userId",
      in = ParameterIn.QUERY,
      description = "Search a user by its id",
      schema = @Schema(type = "string"),
      example = "925b32bc-aed7-4d7e-b40d-da83843f4c6a")
  @Parameter(
      name = "email",
      in = ParameterIn.QUERY,
      description = "Search users by email",
      schema = @Schema(type = "string"),
      example = "user@example.com")
  Page<UserResponseDTO> listUsers(Specification<User> userSpec, @ParameterObject Pageable pageable);
}
