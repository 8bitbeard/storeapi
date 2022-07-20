package br.com.pet.storeapi.api.controllers;

import br.com.pet.storeapi.api.dtos.request.ServiceRequestDTO;
import br.com.pet.storeapi.api.dtos.response.ServiceResponseDTO;
import br.com.pet.storeapi.api.mappers.ServiceMapper;
import br.com.pet.storeapi.api.swagger.ServiceApi;
import br.com.pet.storeapi.domain.entities.Service;
import br.com.pet.storeapi.domain.services.ServiceService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
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

@RestController
@AllArgsConstructor
@RequestMapping("/v1/services")
public class ServiceController implements ServiceApi {

  private final ServiceMapper serviceMapper;
  private final ServiceService serviceService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ServiceResponseDTO createService(@RequestBody @Valid ServiceRequestDTO serviceRequestDTO) {
    Service service = serviceMapper.toEntity(serviceRequestDTO);
    Service newService = serviceService.createService(service);

    return serviceMapper.toDto(newService);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Page<ServiceResponseDTO> listServices(
      @And({@Spec(path = "description", spec = Like.class)}) Specification<Service> serviceSpec,
      @PageableDefault(sort = "description", direction = Sort.Direction.ASC) Pageable pageable) {
    return serviceService.listServicesByPage(serviceSpec, pageable).map(serviceMapper::toDto);
  }
}
