package com.aditya.service;

import com.aditya.model.floor.ParkingFloor;
import com.aditya.model.slot.ParkingSlot;
import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.model.ticket.ParkingExitTicket;
import com.aditya.model.vehicle.Vehicle;
import com.aditya.model.vehicle.VehicleType;
import com.aditya.repo.ParkingLotRepository;
import com.aditya.strategy.ParkingStrategy;
import java.nio.file.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
  private final ParkingLotRepository parkingLotRepository;
  private final ParkingFloorService parkingFloorService;
  private final VehicleService vehicleService;
  private final ParkingStrategy parkingStrategy;
  private final ParkingEntryTicketService parkingEntryTicketService;
  private final ParkingExitTicketService parkingExitTicketService;

  public ParkingLotService(
      ParkingLotRepository parkingLotRepository,
      ParkingFloorService parkingFloorService,
      VehicleService vehicleService,
      ParkingStrategy parkingStrategy,
      ParkingEntryTicketService parkingEntryTicketService,
      ParkingExitTicketService parkingExitTicketService) {
    this.parkingLotRepository = parkingLotRepository;
    this.parkingFloorService = parkingFloorService;
    this.vehicleService = vehicleService;
    this.parkingStrategy = parkingStrategy;
    this.parkingEntryTicketService = parkingEntryTicketService;
    this.parkingExitTicketService = parkingExitTicketService;
  }

  public ParkingFloor addFloor() {
    ParkingFloor parkingFloor = parkingFloorService.addFloor();
    parkingLotRepository.addParkingFloor(parkingFloor);
    return parkingFloor;
  }

  public ParkingEntryTicket parkVehicle(
      String ownerName, String vehicleNNumber, String licenseNumber, VehicleType vehicleType) {
    Vehicle vehicle =
        vehicleService.addVehicle(ownerName, vehicleNNumber, licenseNumber, vehicleType);
    ParkingSlot parkingSlot = parkingStrategy.getParkingSlot(vehicleType);
    return parkingEntryTicketService.createTicket(vehicle.getId(), parkingSlot);
  }

  public ParkingExitTicket exitVehicle(String parkingEntryTicketId) throws AccessDeniedException {
    ParkingEntryTicket parkingEntryTicket = parkingEntryTicketService.getById(parkingEntryTicketId);
    if (parkingEntryTicket.isPaid()) {
      throw new AccessDeniedException("Vehicle already exited!");
    }
    parkingEntryTicket.setPaid(true);
    parkingFloorService.freeSlot(parkingEntryTicket.getParkingSlot());
    return parkingExitTicketService.createTicket(parkingEntryTicketId);
  }
}
