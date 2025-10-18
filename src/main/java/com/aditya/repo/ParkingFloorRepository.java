package com.aditya.repo;

import com.aditya.model.floor.ParkingFloor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingFloorRepository {
  Map<String, ParkingFloor> parkingFloorMap;

  public ParkingFloorRepository() {
    parkingFloorMap = new LinkedHashMap<>();
  }

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
