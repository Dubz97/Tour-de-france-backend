package com.example.eksame24timer3005backend.controllers;


import com.example.eksame24timer3005backend.model.Cykelhold;
import com.example.eksame24timer3005backend.repository.CykelholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RESTControllerCykelhold {


  @Autowired
  CykelholdRepository cykelholdRepository;

  /**
   * Henter en liste af alle cykelhold
   * @return alle hold
   */
  @GetMapping("/cykelhold")
  public List<Cykelhold> getAllCykelhold() {
    return cykelholdRepository.findAll();
  }
}
