package com.aditya.model.slot;

import com.aditya.model.vehicle.VehicleType;

public class FourWheelerParkingSlot extends ParkingSlot {

  public FourWheelerParkingSlot(String floorId) {
    super(floorId);
  }

  @Override
  public VehicleType getType() {
    return VehicleType.FOUR_WHEELER;
  }

  @Override
  public double getPricePerHour() {
    return 250.0;
  }
}
