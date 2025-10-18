package com.aditya.service;

import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.model.ticket.ParkingExitTicket;
import com.aditya.repo.ParkingEntryTicketRepository;
import com.aditya.repo.ParkingExitTicketRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.Map;

@Service
public class ParkingExitTicketService {
    private final ParkingExitTicketRepository parkingExitTicketRepository;
    private final ParkingEntryTicketService parkingEntryTicketService;

    public ParkingExitTicketService(ParkingEntryTicketService parkingEntryTicketService, ParkingExitTicketRepository parkingExitTicketRepository) {
        this.parkingEntryTicketService = parkingEntryTicketService;
        this.parkingExitTicketRepository = parkingExitTicketRepository;
    }

    public ParkingExitTicket createTicket(Map<String,String> filters) {
        ParkingEntryTicket parkingEntryTicket = parkingEntryTicketService.getById(filters);
        String vehicleId = parkingEntryTicket.getVehicleId();
        String id = "exit-ticket-" + parkingEntryTicket.getId();

        LocalTime exitTime = LocalTime.now();
        Duration parkingDuration = Duration.between(parkingEntryTicket.getEntryTime(), exitTime);
        double amount = parkingDuration.toSeconds() * parkingEntryTicket.getParkingSlot().getPricePerHour();
        ParkingExitTicket parkingExitTicket = new ParkingExitTicket(
                id,
                vehicleId,
                parkingEntryTicket.getId(),
                parkingDuration,
                amount
        );
        parkingEntryTicketService.resolve(parkingEntryTicket.getId());
        parkingExitTicketRepository.save(parkingExitTicket);
        return parkingExitTicket;
    }
}
