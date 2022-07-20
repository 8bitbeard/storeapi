package br.com.pet.storeapi.domain.entities;

import java.util.UUID;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column private String cep;

  @Column private String logradouro;

  @Column private String complemento;

  @Column private String bairro;

  @Column private String localidade;

  @Column private String uf;

  @Column private String numero;
}
