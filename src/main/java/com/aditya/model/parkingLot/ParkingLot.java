package com.aditya.model.parkingLot;

import com.aditya.model.floor.ParkingFloor;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {
  List<ParkingFloor> parkingFloors;

  public ParkingLot() {
    parkingFloors = new ArrayList<>();
  }
}
