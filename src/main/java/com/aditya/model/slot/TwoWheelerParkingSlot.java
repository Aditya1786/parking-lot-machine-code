package com.aditya.model.slot;

import com.aditya.model.vehicle.VehicleType;

public class TwoWheelerParkingSlot extends ParkingSlot {

  public TwoWheelerParkingSlot(String floorId) {
    super(floorId);
  }

  @Override
  public VehicleType getType() {
    return VehicleType.TWO_WHEELER;
  }

  @Override
  public double getPricePerHour() {
    return 50.0;
  }
}
