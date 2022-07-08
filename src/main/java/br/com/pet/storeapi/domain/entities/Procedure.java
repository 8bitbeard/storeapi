package br.com.pet.storeapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "procedures")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String description;

    @Column
    private BigDecimal value;

    @JsonIgnore
    @OneToMany(mappedBy = "procedure")
    private List<Schedule> schedules = new ArrayList<>();
}
