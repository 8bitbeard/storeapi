package br.com.pet.storeapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class Service {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column private String description;

  @Column(name = "`value`")
  private BigDecimal value;

  @JsonIgnore
  @OneToMany(mappedBy = "service")
  private List<Schedule> schedules = new ArrayList<>();
}
