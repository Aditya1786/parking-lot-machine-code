package com.aditya.repo;

import com.aditya.model.floor.ParkingFloor;
import com.aditya.model.parkingLot.ParkingLot;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingLotRepository {
  private final ParkingLot parkingLot;

  public ParkingLotRepository() {
    this.parkingLot = new ParkingLot();
  }

  public void addParkingFloor(ParkingFloor parkingFloor) {
    parkingLot.getParkingFloors().add(parkingFloor);
  }

  public void removeParkingFloor(ParkingFloor parkingFloor) {
    parkingLot.getParkingFloors().remove(parkingFloor);
  }

  public List<ParkingFloor> getAllParkingFloors() {
    return parkingLot.getParkingFloors();
  }
}
