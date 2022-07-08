package br.com.pet.storeapi.domain.services;

import br.com.pet.storeapi.api.dtos.response.LoginResponseDTO;
import br.com.pet.storeapi.api.exceptions.AuthenticationFailedException;
import br.com.pet.storeapi.domain.security.TokenManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;

    public String authenticate(Authentication authenticationToken) {
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            String jwt = tokenManager.generateToken(authentication);

            return jwt;
        } catch (AuthenticationException ex) {
            throw new AuthenticationFailedException();
        }
    }
}
