package com.example.eksame24timer3005backend.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Cykelrytter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int rytterId;

  @Column(nullable = false)
  private String navn;

  private double totalTid;

  private int bjegpoint;

  private int spurtpoint;

  private int alder;

  private String land;
  @ManyToOne
  @JoinColumn(name = "holdId")
  private Cykelhold cykelhold;

}
