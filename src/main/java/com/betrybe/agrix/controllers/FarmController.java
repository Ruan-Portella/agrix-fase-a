package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class FarmController.
 */
@RestController
@RequestMapping(value = "/")
public class FarmController {

  private final FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
 * Método createFarm.
 */
  @PostMapping("/farms")
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.createFarm(farmDto.toFarm());

    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }
}