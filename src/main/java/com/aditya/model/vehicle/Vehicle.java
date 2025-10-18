package com.aditya.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
  private final String id;
  private final String ownerName;
  private final String vehicleNumber;
  private final VehicleType vehicleType;
  private final String licenseNumber;
}
