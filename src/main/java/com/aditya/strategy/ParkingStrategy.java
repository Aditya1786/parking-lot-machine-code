package com.aditya.strategy;

import com.aditya.model.floor.ParkingFloor;
import com.aditya.model.slot.ParkingSlot;
import com.aditya.model.vehicle.VehicleType;
import com.aditya.service.ParkingFloorService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ParkingStrategy {
  private final ParkingFloorService parkingFloorService;

  public ParkingStrategy(ParkingFloorService parkingFloorService) {
    this.parkingFloorService = parkingFloorService;
  }

  public ParkingSlot getParkingSlot(VehicleType vehicleType) {
    List<ParkingFloor> availableFloors = parkingFloorService.getAllAvailableFloors();
    for (ParkingFloor floor : availableFloors) {
      List<ParkingSlot> availableSlots =
          parkingFloorService.getAllAvailableSlotsForFloor(floor.getFloorId());
      for (ParkingSlot parkingSlot : availableSlots) {
        if (parkingSlot.getType().equals(vehicleType)) {
          parkingSlot.setAvailable(false);
          return parkingSlot;
        }
      }
    }
    return null;
  }
}
