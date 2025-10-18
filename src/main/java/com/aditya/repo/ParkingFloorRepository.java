package com.aditya.repo;

import com.aditya.model.floor.ParkingFloor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ParkingFloorRepository {
  Map<String, ParkingFloor> parkingFloorMap;

  public void save(ParkingFloor parkingFloor) {
    parkingFloorMap.put(parkingFloor.getFloorId(), parkingFloor);
  }

  public void remove(ParkingFloor parkingFloor) {
    parkingFloorMap.remove(parkingFloor.getFloorId());
  }

  public ParkingFloor getById(String parkingFloorId) {
    return parkingFloorMap.get(parkingFloorId);
  }

  public List<ParkingFloor> getAll() {
    return parkingFloorMap.values().stream().toList();
  }
}
