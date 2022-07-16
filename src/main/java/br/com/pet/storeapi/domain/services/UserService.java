package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.exceptions.UserAlreadyExistsException;
import br.com.pet.storeapi.api.exceptions.UserNotFoundException;
import br.com.pet.storeapi.domain.entities.Role;
import br.com.pet.storeapi.domain.entities.RoleEnum;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.infra.database.repositories.RoleRepository;
import br.com.pet.storeapi.infra.database.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public User createUser(User user) {
    Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
    if (existingUser.isPresent()) {
      throw new UserAlreadyExistsException();
    }

    Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN);
    user.addRole(adminRole);
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);
  }

  public User findUserByEmail(String userEmail) {
    return userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);

    return user;
  }

  public UserDetails loadUserById(UUID userId) {
    User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

    return user;
  }

  public Page<User> listUsersByPage(Specification<User> userSpec, Pageable pageable) {
    return userRepository.findAll(userSpec, pageable);
  }
}
