package com.aditya.repo;


import com.aditya.model.floor.ParkingFloor;
import com.aditya.model.parkingLot.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingLotRepository {
    private final ParkingLot parkingLot;

    public ParkingLotRepository() {
        this.parkingLot = new ParkingLot();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingLot.getParkingFloors().add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor) {
        parkingLot.getParkingFloors().remove(parkingFloor);
    }

    public List<ParkingFloor> getAllParkingFloors() {
        return  parkingLot.getParkingFloors();
    }


}
