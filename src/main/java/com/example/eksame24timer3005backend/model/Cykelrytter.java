package com.example.eksame24timer3005backend.model;

import javax.persistence.*;

@Entity
public class Cykelrytter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int rytterId;

  @Column(nullable = false)
  private String navn;

  private double totalTid;

  private int bjergpoint;

  private int spurtpoint;

  @Column(nullable = false)
  private int alder;

  private String land;
  @ManyToOne
  @JoinColumn(name = "holdId")
  private Cykelhold cykelhold;




  public int getRytterId() {
    return rytterId;
  }

  public void setRytterId(int rytterId) {
    this.rytterId = rytterId;
  }

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
  }

  public double getTotalTid() {
    return totalTid;
  }

  public void setTotalTid(double totalTid) {
    this.totalTid = totalTid;
  }

  public int getBjergpoint() {
    return bjergpoint;
  }

  public void setBjergpoint(int bjegpoint) {
    this.bjergpoint = bjegpoint;
  }

  public int getSpurtpoint() {
    return spurtpoint;
  }

  public void setSpurtpoint(int spurtpoint) {
    this.spurtpoint = spurtpoint;
  }

  public int getAlder() {
    return alder;
  }

  public void setAlder(int alder) {
    this.alder = alder;
  }

  public String getLand() {
    return land;
  }

  public void setLand(String land) {
    this.land = land;
  }

  public Cykelhold getCykelhold() {
    return cykelhold;
  }

  public void setCykelhold(Cykelhold cykelhold) {
    this.cykelhold = cykelhold;
  }
}
