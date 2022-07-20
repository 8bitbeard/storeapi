package br.com.pet.storeapi.domain.entities;

import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Enumerated(EnumType.STRING)
  private RoleEnum name;

  //    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
  //    private List<User> users = new ArrayList<>();

  @Override
  public String getAuthority() {
    return name.name();
  }
}
