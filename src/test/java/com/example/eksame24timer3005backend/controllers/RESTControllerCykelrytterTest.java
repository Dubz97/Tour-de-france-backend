package com.example.eksame24timer3005backend.controllers;

import com.example.eksame24timer3005backend.model.Cykelhold;
import com.example.eksame24timer3005backend.model.Cykelrytter;
import com.example.eksame24timer3005backend.repository.CykelholdRepository;
import com.example.eksame24timer3005backend.repository.CykelrytterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class RESTControllerCykelrytterTest {

  @Autowired
  RESTControllerCykelrytter restControllerCykelrytter;


  @Autowired
  CykelholdRepository cykelholdRepository;

  @Autowired
  CykelrytterRepository cykelrytterRepository;

  @BeforeTestMethod
  public void beforeTest() {
    cykelrytterRepository.deleteAll();
  }

  /**
   *
   */
  @Test
  void postCykelrytter() {
    Cykelrytter cykelrytter = new Cykelrytter();
    cykelrytter.setNavn("TestPerson");
    cykelrytter.setTotalTid(305);
    cykelrytter.setBjergpoint(2);
    cykelrytter.setSpurtpoint(1);
    cykelrytter.setAlder(19);
    cykelrytter.setLand("Estland");

    Cykelhold cykelhold = new Cykelhold();
    cykelhold.setHoldNavn("Saxo");
    cykelhold.setHoldLand("Danmark");
    cykelrytter.setCykelhold(cykelhold);

    restControllerCykelrytter.postCykelrytter(cykelrytter);

    Optional<Cykelrytter> optionalCykelrytter = cykelrytterRepository.findById(cykelrytter.getRytterId());
    assertThat(optionalCykelrytter.isPresent()).isTrue();
    assertEquals("TestPerson", optionalCykelrytter.get().getNavn());

  }

  @Test
  void deleteCykelrytter() {
    Cykelrytter cykelrytter = new Cykelrytter();
    cykelrytter.setRytterId(99);
    cykelrytter.setNavn("TestPerson");
    cykelrytter.setTotalTid(305);
    cykelrytter.setBjergpoint(2);
    cykelrytter.setSpurtpoint(1);
    cykelrytter.setAlder(19);
    cykelrytter.setLand("Estland");

    Cykelhold cykelhold = new Cykelhold();
    cykelhold.setHoldNavn("Saxo");
    cykelhold.setHoldLand("Danmark");
    cykelrytter.setCykelhold(cykelhold);

    restControllerCykelrytter.deleteCykelrytter(99);

    Optional<Cykelrytter> findRytter = cykelrytterRepository.findById(99);


// needs to get verified??
//    assertThat(findRytter.isPresent()).isFalse();
  }
}
