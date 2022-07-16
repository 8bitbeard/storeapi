package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.exceptions.ServiceAlreadyExistsException;
import br.com.pet.storeapi.domain.entities.Service;
import br.com.pet.storeapi.infra.database.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.transaction.Transactional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Transactional
    public Service createService(Service service) {
        boolean nameInUse = serviceRepository.findByDescription(service.getDescription())
                .stream()
                .anyMatch(existingService -> !existingService.equals(service));
        if(nameInUse) {
            throw new ServiceAlreadyExistsException();
        }
        return serviceRepository.save(service);
    }

    public Page<Service> listServicesByPage(Specification<Service> serviceSpec, Pageable pageable) {
        return serviceRepository.findAll(serviceSpec, pageable);
    }
}
