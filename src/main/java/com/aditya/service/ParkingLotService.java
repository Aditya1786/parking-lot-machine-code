package com.aditya.service;

import com.aditya.repo.ParkingLotRepository;

public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingFloorService parkingFloorService;
    
    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingFloorService parkingFloorService) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorService = parkingFloorService;
    }


}
