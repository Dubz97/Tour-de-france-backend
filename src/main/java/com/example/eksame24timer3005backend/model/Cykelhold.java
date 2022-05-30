package com.example.eksame24timer3005backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
  @JsonBackReference
  private Set<Cykelrytter> cykelryttere = new HashSet<>();


  public int getHoldId() {
    return holdId;
  }

  public void setHoldId(int holdId) {
    this.holdId = holdId;
  }

  public String getHoldNavn() {
    return holdNavn;
  }

  public void setHoldNavn(String holdNavn) {
    this.holdNavn = holdNavn;
  }

  public String getHoldLand() {
    return holdLand;
  }

  public void setHoldLand(String holdLand) {
    this.holdLand = holdLand;
  }

  public Set<Cykelrytter> getCykelryttere() {
    return cykelryttere;
  }

  public void setCykelryttere(Set<Cykelrytter> cykelryttere) {
    this.cykelryttere = cykelryttere;
  }
}
