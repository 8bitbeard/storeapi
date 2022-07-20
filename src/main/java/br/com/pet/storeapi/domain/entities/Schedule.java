package br.com.pet.storeapi.domain.entities;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "schedules")
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "guardian_id")
  private Guardian guardian;

  @ManyToOne
  @JoinColumn(name = "service_id")
  private Service service;

  @Column private OffsetDateTime scheduleTime;
}
