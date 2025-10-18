package com.aditya.service;

import com.aditya.model.slot.ParkingSlot;
import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.repo.ParkingEntryTicketRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingEntryTicketService {
  private final ParkingEntryTicketRepository parkingEntryTicketRepository;

  public ParkingEntryTicketService(ParkingEntryTicketRepository parkingEntryTicketRepository) {
    this.parkingEntryTicketRepository = parkingEntryTicketRepository;
  }

  public ParkingEntryTicket createTicket(String vehicleId, ParkingSlot parkingSlot) {
    String id = "parking-entry-" + parkingEntryTicketRepository.getAll().size();
    ParkingEntryTicket parkingEntryTicket = new ParkingEntryTicket(id, vehicleId, parkingSlot);
    parkingEntryTicketRepository.save(parkingEntryTicket);
    return parkingEntryTicket;
  }

  public ParkingEntryTicket getById(String id) {
    return parkingEntryTicketRepository.getById(id);
  }

  public void resolve(String id) {
    ParkingEntryTicket parkingEntryTicket = parkingEntryTicketRepository.getById(id);
    parkingEntryTicket.setPaid(true);
  }
}
