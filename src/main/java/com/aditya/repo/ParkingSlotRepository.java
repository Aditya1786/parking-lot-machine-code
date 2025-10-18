package com.aditya.repo;

import com.aditya.model.slot.ParkingSlot;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ParkingSlotRepository {
  private final Map<String, ParkingSlot> parkingSlotMap;

  public ParkingSlotRepository() {
    this.parkingSlotMap = new LinkedHashMap<>();
  }

  public void save(ParkingSlot parkingSlot) {
    parkingSlotMap.put(parkingSlot.getSlotId(), parkingSlot);
  }

  public void remove(ParkingSlot parkingSlot) {
    parkingSlotMap.remove(parkingSlot.getSlotId());
  }

  public ParkingSlot getById(String parkingSlotId) {
    return parkingSlotMap.get(parkingSlotId);
  }

  public List<ParkingSlot> getAll() {
    return parkingSlotMap.values().stream().toList();
  }
}
