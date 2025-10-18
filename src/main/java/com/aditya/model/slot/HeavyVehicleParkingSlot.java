package com.aditya.model.slot;

import com.aditya.model.vehicle.VehicleType;

public class HeavyVehicleParkingSlot extends ParkingSlot {

  public HeavyVehicleParkingSlot(String floorId) {
    super(floorId);
  }

  @Override
  public VehicleType getType() {
    return VehicleType.HEAVY_VEHICLE;
  }

  @Override
  public double getPricePerHour() {
    return 500.0;
  }
}
