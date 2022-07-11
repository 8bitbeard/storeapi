package br.com.pet.storeapi.domain.services;

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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    public Page<Pet> listPetsByPage(Pageable pageable) {
        return petRepository.findAll(pageable);
    }
}
