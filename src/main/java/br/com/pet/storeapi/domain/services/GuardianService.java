package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.dtos.response.ViaCepResponseDTO;
import br.com.pet.storeapi.api.exceptions.DocumentAlreadyInUseException;
import br.com.pet.storeapi.api.exceptions.EmailAlreadyInUseException;
import br.com.pet.storeapi.api.exceptions.InvalidCepException;
import br.com.pet.storeapi.domain.entities.Address;
import br.com.pet.storeapi.domain.entities.Guardian;
import br.com.pet.storeapi.domain.entities.Role;
import br.com.pet.storeapi.domain.entities.RoleEnum;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.infra.database.repositories.AddressRepository;
import br.com.pet.storeapi.infra.database.repositories.GuardianRepository;
import br.com.pet.storeapi.infra.database.repositories.RoleRepository;
import br.com.pet.storeapi.infra.database.repositories.UserRepository;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@AllArgsConstructor
public class GuardianService {

  private final RoleRepository roleRepository;
  private final UserRepository userRepository;
  private final GuardianRepository guardianRepository;
  private final AddressRepository addressRepository;
  private final PasswordEncoder passwordEncoder;
  private final WebClient viaCepWebClient;

  @Transactional
  public Guardian createGuardian(User newUser, Guardian newGuardian, Address newAddress) {
    boolean userAlreadyExists =
        userRepository.findByEmail(newUser.getEmail()).stream()
            .anyMatch(existingUser -> !existingUser.equals(newUser));

    if (userAlreadyExists) {
      throw new EmailAlreadyInUseException();
    }

    boolean documentInUse =
        guardianRepository.findByDocument(newGuardian.getDocument()).stream()
            .anyMatch(existingGuardian -> !existingGuardian.equals(newGuardian));

    if (documentInUse) {
      throw new DocumentAlreadyInUseException();
    }

    try {
      ViaCepResponseDTO response =
          viaCepWebClient
              .method(HttpMethod.GET)
              .uri("/{cep}/json/", newAddress.getCep())
              .retrieve()
              .bodyToMono(ViaCepResponseDTO.class)
              .block();

      if (response.getErro() != null) {
        throw new InvalidCepException();
      }

      newAddress.setLogradouro(response.getLogradouro());
      newAddress.setBairro(response.getBairro());
      newAddress.setLocalidade(response.getLocalidade());
      newAddress.setUf(response.getUf());
    } catch (WebClientResponseException ex) {
      throw new InvalidCepException();
    }

    Role role = roleRepository.findByName(RoleEnum.ROLE_CLIENT);

    newUser.addRole(role);
    newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
    userRepository.save(newUser);

    addressRepository.save(newAddress);
    newGuardian.setUser(newUser);
    newGuardian.setAddress(newAddress);

    return guardianRepository.save(newGuardian);
  }

  public Page<Guardian> listGuardiansByPage(
      Specification<Guardian> guardianSpec, Pageable pageable) {
    return guardianRepository.findAll(guardianSpec, pageable);
  }
}
