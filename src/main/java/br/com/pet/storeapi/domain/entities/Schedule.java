package br.com.pet.storeapi.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

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
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;

    @Column
    private OffsetDateTime scheduleTime;
}