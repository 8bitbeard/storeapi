package br.com.pet.storeapi.domain.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.pet.storeapi.domain.entities.Guardian;

@ExtendWith(MockitoExtension.class)
class GuardianServiceTest {

  @Nested
  class CreateGuardianTest {
    @Test
    @DisplayName("should create a new guardian successfully")
    public void shouldCreateAguardian() {
      Guardian guardian = new Guardian(
          
          );
    }
  }
}
