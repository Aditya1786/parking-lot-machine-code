package com.aditya.service;

import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.model.ticket.ParkingExitTicket;
import com.aditya.repo.ParkingExitTicketRepository;
import java.time.Duration;
import java.time.LocalTime;
import org.springframework.stereotype.Service;

@Service
public class ParkingExitTicketService {
  private final ParkingExitTicketRepository parkingExitTicketRepository;
  private final ParkingEntryTicketService parkingEntryTicketService;

  public ParkingExitTicketService(
      ParkingEntryTicketService parkingEntryTicketService,
      ParkingExitTicketRepository parkingExitTicketRepository) {
    this.parkingEntryTicketService = parkingEntryTicketService;
    this.parkingExitTicketRepository = parkingExitTicketRepository;
  }

  public ParkingExitTicket createTicket(String parkingEntryTicketId) {
    ParkingEntryTicket parkingEntryTicket = parkingEntryTicketService.getById(parkingEntryTicketId);
    String vehicleId = parkingEntryTicket.getVehicleId();
    String id = "exit-ticket-" + parkingEntryTicket.getId();

    LocalTime exitTime = LocalTime.now();
    Duration parkingDuration = Duration.between(parkingEntryTicket.getEntryTime(), exitTime);
    double amount =
        parkingDuration.toSeconds() * parkingEntryTicket.getParkingSlot().getPricePerHour();
    ParkingExitTicket parkingExitTicket =
        new ParkingExitTicket(id, vehicleId, parkingEntryTicket.getId(), parkingDuration, amount);
    parkingEntryTicketService.resolve(parkingEntryTicket.getId());
    parkingExitTicketRepository.save(parkingExitTicket);
    return parkingExitTicket;
  }
}
