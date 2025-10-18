package com.aditya.service;

import com.aditya.model.floor.ParkingFloor;
import com.aditya.model.slot.ParkingSlot;
import com.aditya.model.vehicle.VehicleType;
import com.aditya.repo.ParkingFloorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ParkingFloorService {
  private final ParkingFloorRepository parkingFloorRepository;
  private final ParkingSlotService parkingSlotService;

  public ParkingFloorService(
      ParkingFloorRepository parkingFloorRepository, ParkingSlotService parkingSlotService) {
    this.parkingFloorRepository = parkingFloorRepository;
    this.parkingSlotService = parkingSlotService;
  }

  public ParkingFloor addFloor() {
    String floorId = "floor-" + (parkingFloorRepository.getAll().size());
    List<ParkingSlot> parkingSlotList = initializeParkingSlots(floorId);
    ParkingFloor parkingFloor = new ParkingFloor(floorId, parkingSlotList, false);
    parkingFloorRepository.save(parkingFloor);
    return parkingFloor;
  }

  public void removeParkingFloor(String floorId) {
    ParkingFloor parkingFloor = parkingFloorRepository.getById(floorId);
    List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
    for (ParkingSlot parkingSlot : parkingSlotList) {
      parkingSlotService.removeSlot(parkingSlot.getSlotId());
    }
    parkingFloorRepository.remove(parkingFloor);
  }

  public ParkingFloor getParkingFloor(String floorId) {
    return parkingFloorRepository.getById(floorId);
  }

  public List<ParkingFloor> getAll() {
    return parkingFloorRepository.getAll();
  }

  public List<ParkingSlot> getAllSlotsForFloor(String floorId) {
    return parkingFloorRepository.getById(floorId).getParkingSlotList();
  }

  public List<ParkingSlot> getAllAvailableSlotsForFloor(String floorId) {
    return parkingFloorRepository.getById(floorId).getParkingSlotList().stream()
        .filter(ParkingSlot::isAvailable)
        .toList();
  }

  public List<ParkingFloor> getAllAvailableFloors() {
    return parkingFloorRepository.getAll().stream().filter(floor -> !floor.isFull()).toList();
  }

  public void freeSlot(ParkingSlot parkingSlot) {
    parkingSlot.setAvailable(true);
  }

  private List<ParkingSlot> initializeParkingSlots(String floorId) {
    List<ParkingSlot> parkingSlotList = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      if (i < 40) {
        ParkingSlot parkingSlot = parkingSlotService.createSlot(VehicleType.TWO_WHEELER, floorId);
        parkingSlotList.add(parkingSlot);
      } else if (i < 70) {
        ParkingSlot parkingSlot = parkingSlotService.createSlot(VehicleType.FOUR_WHEELER, floorId);
        parkingSlotList.add(parkingSlot);
      } else {
        ParkingSlot parkingSlot = parkingSlotService.createSlot(VehicleType.HEAVY_VEHICLE, floorId);
        parkingSlotList.add(parkingSlot);
      }
    }

    return parkingSlotList;
  }
}
