package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * FarmDTO.
 */
public record FarmDto(Long id, String name, double size) {
  public Farm toFarm() {
    return new Farm(id, name, size);
  }
}