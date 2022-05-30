package com.example.eksame24timer3005backend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cykelhold {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int holdId;

@Column(nullable = false)
  private String holdNavn;


private String holdLand;

@OneToMany
@JoinColumn(name = "holdId")
private Set<Cykelrytter> cykelryttere = new HashSet<>();
}
