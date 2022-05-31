package com.example.eksame24timer3005backend.controllers;


import com.example.eksame24timer3005backend.model.Cykelhold;
import com.example.eksame24timer3005backend.model.Cykelrytter;
import com.example.eksame24timer3005backend.repository.CykelholdRepository;
import com.example.eksame24timer3005backend.repository.CykelrytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RESTControllerCykelrytter {

  @Autowired
  CykelrytterRepository cykelrytterRepository;

  @Autowired
  CykelholdRepository cykelholdRepository;


  @GetMapping("/cykelryttere")
  public List<Cykelrytter> getAllCykelryttere() {
    return cykelrytterRepository.findAll();
  }

  /**
   * Metode til at oprette en cykelrytter
   * @param cykelrytter
   * @return cykelrytter
   */
  @PostMapping("/create/cykelrytter")
  @ResponseStatus(HttpStatus.CREATED)
  public Cykelrytter postCykelrytter(@RequestBody Cykelrytter cykelrytter) {
    return cykelrytterRepository.save(cykelrytter);
  }

  /**
   * Metode til at update cykelrytter (Testest i Postman)
   * @param id
   * @param cykelrytter
   * @return cykelrytter, samt StatusKode
   */
  @PutMapping("/update/cykelrytter/{id}")
  public ResponseEntity<Cykelrytter> updateCykelrytter(
      @PathVariable int id, @RequestBody Cykelrytter cykelrytter) {
    cykelrytter.setRytterId(id);
    Optional<Cykelrytter> optionalCykelrytter = cykelrytterRepository.findById(id);
    if (optionalCykelrytter.isPresent()) {
      cykelrytterRepository.save(cykelrytter);
      return new ResponseEntity<>(cykelrytter, HttpStatus.OK);
    } else {
      Cykelrytter notFound = new Cykelrytter();
      notFound.setNavn("Not found by id: " + id);
      return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Slette en cykelrytter ud fra givent ID
   * @param id
   * @return success/failure besked samt statuskode
   */
  @DeleteMapping("/delete/cykelrytter/{id}")
  public ResponseEntity<String> deleteCykelrytter(@PathVariable int id) {
    try {
      cykelrytterRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not find id = " + id, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Henter alle ryttere fra det holdid man giver
   * @param holdId
   * @return listen med de rigtige ryttere
   */
  @GetMapping("/cykel/cykelhold/{holdId}")
  public List<Cykelrytter> getCykelrytterFraHold(@PathVariable int holdId) {
    List<Cykelrytter> obj = cykelrytterRepository.findAll();
    List<Cykelrytter> result = new ArrayList<>();
    if (!obj.isEmpty()) {
      for (Cykelrytter k : obj) {
        if (k.getCykelhold().getHoldId() == holdId) {
          result.add(k);
        }
      }
    }
    return result;
  }
}
