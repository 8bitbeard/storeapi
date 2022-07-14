package br.com.pet.storeapi.api.swagger;

import java.util.UUID;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.pet.storeapi.api.dtos.request.PetRequestDTO;
import br.com.pet.storeapi.api.dtos.response.PetResponseDTO;
import br.com.pet.storeapi.api.dtos.response.PetWithGuardianResponseDTO;
import br.com.pet.storeapi.api.dtos.response.ScheduleResponseDTO;
import br.com.pet.storeapi.domain.entities.Pet;
import br.com.pet.storeapi.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pets")
public interface PetApi {

  @Operation(summary = "Create a new pet", description = "Create a new pet. This operation can only be performed by an Logged in guardian user")
  public PetResponseDTO createPet(PetRequestDTO petRequestDTO);

  @Operation(summary = "List all existing pets", description = "List all existing pets. This operation can only be performed by an Logged in admin user")
  @Parameter(name = "name", in = ParameterIn.QUERY, description = "Search by pet name", schema = @Schema(type = "string"), example = "Rex")
  @Parameter(name = "breed", in = ParameterIn.QUERY, description = "Search by pet breed", schema = @Schema(type = "string"), example = "Vira Lata")
  @Parameter(name = "specie", in = ParameterIn.QUERY, description = "Search by pet specie", schema = @Schema(type = "string"), example = "Gato")
  @Parameter(name = "petSpec", hidden = true)
  public Page<PetWithGuardianResponseDTO> listPets(Specification<Pet> petSpec, @ParameterObject Pageable pageable);

  @Operation(summary = "List all pet appointments", description = "List all all pet appointments. This operation can only be performed by any Logged in user")
  @Parameter(name = "userDetails", hidden = true)
  public Page<ScheduleResponseDTO> listPetSchedules(User userDetails, UUID petId, @ParameterObject Pageable pageable);
}
