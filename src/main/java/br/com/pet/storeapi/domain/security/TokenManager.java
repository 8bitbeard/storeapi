package br.com.pet.storeapi.domain.security;

import br.com.pet.storeapi.domain.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class TokenManager {

  @Value("${storeapi.jwt.secret}")
  private String secret;

  @Value("${storeapi.jwt.expiration}")
  private long expirationInMillis;

  public String generateToken(Authentication authentication) {

    User user = (User) authentication.getPrincipal();

    final Date now = new Date();
    final Date expiration = new Date(System.currentTimeMillis() + expirationInMillis);

    return Jwts.builder()
        .setIssuer("StoreAPI")
        .setSubject(user.getId().toString())
        .setIssuedAt(now)
        .setExpiration(expiration)
        .signWith(SignatureAlgorithm.HS256, this.secret)
        .compact();
  }

  public boolean isValid(String jwt) {
    try {
      Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

  public UUID getUserIdFromToken(String jwt) {
    Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt).getBody();
    return UUID.fromString(claims.getSubject());
  }
}
