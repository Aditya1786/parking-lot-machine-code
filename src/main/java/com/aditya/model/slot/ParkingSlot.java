package com.aditya.model.slot;

import com.aditya.model.vehicle.VehicleType;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class ParkingSlot {
  private final String slotId;
  private boolean isAvailable;
  private final String floorId;

  public ParkingSlot(String floorId) {
    this.slotId = "slot" + UUID.randomUUID();
    this.floorId = floorId;
    this.isAvailable = true;
  }

  public abstract VehicleType getType();

  public abstract double getPricePerHour();
}
