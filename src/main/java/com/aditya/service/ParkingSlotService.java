package com.aditya.service;

import com.aditya.model.slot.FourWheelerParkingSlot;
import com.aditya.model.slot.HeavyVehicleParkingSlot;
import com.aditya.model.slot.ParkingSlot;
import com.aditya.model.slot.TwoWheelerParkingSlot;
import com.aditya.model.vehicle.VehicleType;
import com.aditya.repo.ParkingSlotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingSlotService {
  private final ParkingSlotRepository parkingSlotRepository;

  public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
    this.parkingSlotRepository = parkingSlotRepository;
  }

  public ParkingSlot createSlot(VehicleType vehicleType, String floorId) {
    ParkingSlot parkingSlot = null;
    if (vehicleType.equals(VehicleType.TWO_WHEELER)) {
      parkingSlot = new TwoWheelerParkingSlot(floorId);
    }
    if (vehicleType.equals(VehicleType.FOUR_WHEELER)) {
      parkingSlot = new FourWheelerParkingSlot(floorId);
    }
    if (vehicleType.equals(VehicleType.HEAVY_VEHICLE)) {
      parkingSlot = new HeavyVehicleParkingSlot(floorId);
    }
    parkingSlotRepository.save(parkingSlot);
    return parkingSlot;
  }

  public void removeSlot(String slotId) {
    ParkingSlot parkingSlot = parkingSlotRepository.getById(slotId);
    parkingSlotRepository.remove(parkingSlot);
  }
}
