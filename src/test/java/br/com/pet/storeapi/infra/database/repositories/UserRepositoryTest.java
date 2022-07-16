package br.com.pet.storeapi.infra.database.repositories;

import br.com.pet.storeapi.domain.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfUserEmailExists() {
        String email = "user@example.com";
        User user = new User(
                UUID.fromString("5a9d43fc-0a10-4339-9c31-b67427c51a8d"),
                email,
                "teste",
                new ArrayList<>()
        );
        underTest.save(user);

        Optional<User> userFound = underTest.findByEmail(email);

        assertThat(userFound.isPresent()).isTrue();
    }

    @Test
    void itShouldCheckIfUserEmailDoesNotExists() {
        String email = "user@example.com";

        Optional<User> userFound = underTest.findByEmail(email);

        assertThat(userFound.isPresent()).isFalse();
    }
}