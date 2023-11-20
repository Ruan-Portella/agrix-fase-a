package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class CropController.
 */
@RestController
@RequestMapping()
public class CropController {

  private CropService cropService;
  private FarmService farmService;
  
  public CropController(CropService cropService, FarmService farmService) {
    this.cropService = cropService;
    this.farmService = farmService;
  }

  /**
 * Método createCrop.
 */
  @PostMapping("/farms/{farmId}/crops")
  public ResponseEntity<?> createCrop(@PathVariable Long farmId,
      @RequestBody CropDto cropDto) {
    Optional<Farm> optionalFarm = farmService.getFarmById(farmId);
    if (optionalFarm.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
    }
    return optionalFarm.map(farm -> {
      Crop crop = cropDto.toCrop();
      crop.setFarm(farm);
      Crop savedCrop = cropService.createCrop(crop);
      CropDto.ToResponse response = CropDto.fromEntity(savedCrop);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }).orElse(ResponseEntity.notFound().build());
  }
}