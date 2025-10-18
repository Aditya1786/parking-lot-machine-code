package com.aditya.model.parkingLot;

import com.aditya.model.floor.ParkingFloor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParkingLot {
    List<ParkingFloor> parkingFloors;

    public ParkingLot() {
        parkingFloors = new ArrayList<>();
    }
}
