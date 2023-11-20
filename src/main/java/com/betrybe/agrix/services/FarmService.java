package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Class.
 */
@Service
public class FarmService {
  private FarmRepository farmRepository;

  public FarmService(FarmRepository farmsRepository) {
    this.farmRepository = farmsRepository;
  }

  //Método createFarm.
  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  //Método getAllFarms.
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }
}