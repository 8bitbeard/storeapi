package br.com.pet.storeapi.api.swagger;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.pet.storeapi.api.dtos.request.ProcedureRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ProcedureResponseDTO;
import br.com.pet.storeapi.domain.entities.Procedure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Procedures")
public interface ProcedureApi {

  @Operation(summary = "Create a new procedure", description = "Create a new procedure. This operation can only be performed by an Logged in ADMIN user.")
  public ProcedureResponseDTO createProcedure(ProcedureRequestDTO procedureRequestDTO);

  @Operation(summary = "List all available procedures", description = "List all available procedures. This operation can be performed by any logged in user.")
  @Parameter(name = "procedureSpec", hidden = true)
  @Parameter(name = "description", in = ParameterIn.QUERY, description = "Search by description", schema = @Schema(type = "string"), example = "Tosa")
  public Page<ProcedureResponseDTO> listProcedures(Specification<Procedure> procedureSpec,
      @ParameterObject Pageable pageable);
}
