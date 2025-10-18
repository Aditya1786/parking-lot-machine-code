package com.aditya.model.request;

import com.aditya.model.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequest {
  private String ownerName;
  private String vehicleNumber;
  private String licenseNumber;
  private VehicleType vehicleType;
}
