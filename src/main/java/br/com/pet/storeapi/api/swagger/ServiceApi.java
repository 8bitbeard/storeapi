package br.com.pet.storeapi.api.swagger;

import br.com.pet.storeapi.api.dtos.request.ServiceRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ServiceResponseDTO;
import br.com.pet.storeapi.domain.entities.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@Tag(name = "Services")
public interface ServiceApi {

  @Operation(
      summary = "Create a new service",
      description =
          "Create a new service. This operation can only be performed by an Logged in ADMIN user.")
  public ServiceResponseDTO createService(ServiceRequestDTO serviceRequestDTO);

  @Operation(
      summary = "List all available services",
      description =
          "List all available services. This operation can be performed by any logged in user.")
  @Parameter(name = "serviceSpec", hidden = true)
  @Parameter(
      name = "description",
      in = ParameterIn.QUERY,
      description = "Search by description",
      schema = @Schema(type = "string"),
      example = "Tosa")
  public Page<ServiceResponseDTO> listServices(
      Specification<Service> serviceSpec, @ParameterObject Pageable pageable);
}
