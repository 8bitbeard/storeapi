package br.com.pet.storeapi.domain.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.pet.storeapi.api.exceptions.UserAlreadyExistsException;
import br.com.pet.storeapi.api.exceptions.UserNotFoundException;
import br.com.pet.storeapi.domain.entities.User;
import br.com.pet.storeapi.infra.database.repositories.RoleRepository;
import br.com.pet.storeapi.infra.database.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository, roleRepository, passwordEncoder);
    }

    @Nested
    class CreateUserTest {
        @Test
        @DisplayName("should create a new user successfully")
        void itShouldCreateANewAdminUser() {
            User user = new User(
                    UUID.fromString("5a9d43fc-0a10-4339-9c31-b67427c51a8d"),
                    "user@example.com",
                    "teste",
                    new ArrayList<>()
            );
            underTest.createUser(user);
            ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
            verify(userRepository).save(userArgumentCaptor.capture());

            User capturedUser = userArgumentCaptor.getValue();
            assertThat(capturedUser).isEqualTo(user);
        }

        @Test
        @DisplayName("should throw an exception when the email is already taken")
        void willThrowWhenEmailIsTaken() {
            User user = new User(
                    UUID.fromString("5a9d43fc-0a10-4339-9c31-b67427c51a8d"),
                    "user@example.com",
                    "123456",
                    new ArrayList<>()
            );

            given(userRepository.findByEmail(anyString()))
                    .willReturn(Optional.of(user));

            assertThatThrownBy(() -> underTest.createUser(user))
                    .isInstanceOf(UserAlreadyExistsException.class);

            verify(userRepository, never()).save(any());
        }
    }

    @Nested
    class FindUserByEmailTest {
        @Test
        void itShouldFindAnUserByEmail() {
            User user = new User(
                    UUID.fromString("5a9d43fc-0a10-4339-9c31-b67427c51a8d"),
                    "user@example.com",
                    "123456",
                    new ArrayList<>()
            );

            given(userRepository.findByEmail(anyString()))
                    .willReturn(Optional.of(user));

            underTest.findUserByEmail(user.getEmail());
            verify(userRepository).findByEmail(user.getEmail());
        }

        @Test
        void willThrowWhenUserDoesNotExists() {
            given(userRepository.findByEmail(anyString()))
                    .willReturn(Optional.empty());

            assertThatThrownBy(() -> underTest.findUserByEmail(anyString()))
                    .isInstanceOf(UserNotFoundException.class);
        }
    }

    @Nested
    class LoadUserByUsernameTest {
        @Test
        void itShouldLoadUserByUsername() {
          User user = new User(
            UUID.fromString("5a9d43fc-0a10-4339-9c31-b67427c51a8d"),
            "user@example.com",
            "123456",
            new ArrayList<>()
              );

          given(userRepository.findByEmail(anyString()))
            .willReturn(Optional.of(user));

          underTest.loadUserByUsername(user.getEmail());
          verify(userRepository).findByEmail(user.getEmail());
        }

        @Test
        void willThrownWhenUserDoesNotExists() {
          given(userRepository.findByEmail(anyString()))
            .willReturn(Optional.empty());

          assertThatThrownBy(() -> underTest.loadUserByUsername(anyString()))
            .isInstanceOf(UserNotFoundException.class);
        }
    }

    @Nested
    class LoadUserByIdTest {
        @Test
        void itShouldLoadUSerById() {
            User user = new User(
                    UUID.fromString("5a9d43fc-0a10-4339-9c31-b67427c51a8d"),
                    "user@example.com",
                    "123456",
                    new ArrayList<>()
            );

            given(userRepository.findById(user.getId()))
                    .willReturn(Optional.of(user));

            underTest.loadUserById(user.getId());
            verify(userRepository).findById(user.getId());
        }

        @Test
        void willThrownWhenUserDoesNotExists() {
            UUID userId = UUID.randomUUID();
            given(userRepository.findById(userId))
                    .willReturn(Optional.empty());

            assertThatThrownBy(() -> underTest.loadUserById(userId))
                    .isInstanceOf(UserNotFoundException.class);
        }
    }

    @Nested
    class ListUsersByPageTest {
        @Test
        void itShouldReturnUsersByPage() {
            Page<User> userPaginated = Mockito.mock(Page.class);
            Specification<User> userSpec = Mockito.mock(Specification.class);
            Pageable pageable = Mockito.mock(Pageable.class);
            given(userRepository.findAll(userSpec, pageable))
                    .willReturn(userPaginated);

            underTest.listUsersByPage(userSpec, pageable);
            verify(userRepository).findAll(userSpec, pageable);
        }
    }
}
