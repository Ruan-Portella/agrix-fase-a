package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import org.springframework.stereotype.Service;

/**
 * Class CropService.
 */
@Service
public class CropService {

  private CropRepository cropRepository;

  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }
  
  //Método createCrop.
  public Crop createCrop(Crop crop) {
    return cropRepository.save(crop);
  }
}