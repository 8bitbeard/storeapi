package br.com.pet.storeapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pets")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column private String name;

  @Column private OffsetDateTime birthDate;

  @Column private String breed;

  @Column private String specie;

  @ManyToOne
  @JoinColumn(name = "guardian_id")
  private Guardian guardian;

  @JsonIgnore
  @OneToMany(mappedBy = "pet")
  private List<Schedule> schedules = new ArrayList<>();
}
