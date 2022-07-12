package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.exceptions.ForbiddenException;
import br.com.pet.storeapi.api.exceptions.GuardianNotFoundException;
import br.com.pet.storeapi.api.exceptions.UserNotFoundException;
import br.com.pet.storeapi.domain.entities.Guardian;
import br.com.pet.storeapi.domain.entities.Pet;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.infra.database.repositories.GuardianRepository;
import br.com.pet.storeapi.infra.database.repositories.PetRepository;
import br.com.pet.storeapi.infra.database.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    private final GuardianRepository guardianRepository;

    @Transactional
    public Pet createPet(Pet newPet, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
        Guardian guardian = guardianRepository.findByUserId(user.getId()).orElseThrow(UserNotFoundException::new);

        newPet.setGuardian(guardian);
        Pet pet = petRepository.save(newPet);

        guardian.getPets().add(newPet);
        guardianRepository.save(guardian);

        return pet;
    }

    public Page<Pet> listPetsByPage(Specification<Pet> petSpec, Pageable pageable) {
        return petRepository.findAll(petSpec, pageable);
    }

    public Page<Pet> listGuardianPetsByPage(UUID guardianId, Pageable pageable, User userDetails) {
        Guardian guardian = guardianRepository.findById(guardianId).orElseThrow(GuardianNotFoundException::new);
        if(!userDetails.isAdmin() && !userDetails.getId().equals(guardian.getUser().getId())) {
            throw new ForbiddenException();
        }
        return petRepository.findByGuardianId(guardianId, pageable);
    }
}
