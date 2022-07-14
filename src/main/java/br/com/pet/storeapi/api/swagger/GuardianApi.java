package br.com.pet.storeapi.api.swagger;

import java.util.UUID;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.pet.storeapi.api.dtos.request.GuardianRequestDTO;
import br.com.pet.storeapi.api.dtos.response.GuardianResponseDTO;
import br.com.pet.storeapi.api.dtos.response.PetResponseDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import br.com.pet.storeapi.domain.entities.Guardian;
import br.com.pet.storeapi.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Guardians")
public interface GuardianApi {

  @Operation(summary = "Create a new guardian.", description = "Create a new guardian. This action can be performed by anyone.")
  @SecurityRequirements(value = {})
  public GuardianResponseDTO createGuardian(GuardianRequestDTO guardianRequestDTO);

  @Operation(summary = "List all guardians.", description = "List all guardians. This action can only be performed by an logged in admin user.")
  @Parameter(name = "guardianSpec", hidden = true)
  @Parameter(name = "name", in = ParameterIn.QUERY, description = "Search by pet name", schema = @Schema(type = "string"), example = "Axl Rose")
  @Parameter(name = "phone", in = ParameterIn.QUERY, description = "Search by pet breed", schema = @Schema(type = "string"), example = "11999999999")
  @Parameter(name = "document", in = ParameterIn.QUERY, description = "Search by pet specie", schema = @Schema(type = "string"), example = "02154245064")
  public Page<GuardianResponseDTO> listGuardians(Specification<Guardian> guardianSpec,
      @ParameterObject Pageable pageable);

  @Operation(summary = "List all pets from a guardian", description = "List all pets from a guardian. This action can only be performed by an logged in user.")
  @Parameter(name = "userDetails", hidden = true)
  @Parameter(name = "guardianId", in = ParameterIn.PATH, description = "Thue UUID of the guardian", example = "143889c3-e077-4eb2-8542-0e47aa4437f1")
  public Page<PetResponseDTO> listGuardianPets(User userDetails, UUID guardianId, @ParameterObject Pageable pageable);

  @Operation(summary = "List all appointments from a guardian", description = "List all appointments from a guardian. This action can only be performed by an logged in user.")
  @Parameter(name = "userDetails", hidden = true)
  @Parameter(name = "guardianId", in = ParameterIn.PATH, description = "Thue UUID of the guardian", example = "143889c3-e077-4eb2-8542-0e47aa4437f1")
  public Page<ScheduleResponseDTO> listGuardianSchedules(User userDetails, UUID guardianId,
      @ParameterObject Pageable pageable);

}
