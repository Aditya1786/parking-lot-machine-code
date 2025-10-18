package com.aditya.controller;

import com.aditya.model.floor.ParkingFloor;
import com.aditya.model.request.ParkingRequest;
import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.model.ticket.ParkingExitTicket;
import com.aditya.service.ParkingLotService;
import java.nio.file.AccessDeniedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {
  private final ParkingLotService parkingLotService;

  public ParkingLotController(ParkingLotService parkingLotService) {
    this.parkingLotService = parkingLotService;
  }

  @PutMapping("/floor/add")
  public ResponseEntity<ParkingFloor> addFloor() {
    return ResponseEntity.ok(parkingLotService.addFloor());
  }

  @PostMapping("/park")
  public ResponseEntity<ParkingEntryTicket> parkVehicle(
      @RequestBody ParkingRequest parkingRequest) {
    return ResponseEntity.ok(
        parkingLotService.parkVehicle(
            parkingRequest.getOwnerName(),
            parkingRequest.getVehicleNumber(),
            parkingRequest.getLicenseNumber(),
            parkingRequest.getVehicleType()));
  }

  @GetMapping("/{parkingEntryTicketId}/exit")
  public ResponseEntity<ParkingExitTicket> exitVehicle(@PathVariable String parkingEntryTicketId)
      throws AccessDeniedException {
    return ResponseEntity.ok(parkingLotService.exitVehicle(parkingEntryTicketId));
  }
}
