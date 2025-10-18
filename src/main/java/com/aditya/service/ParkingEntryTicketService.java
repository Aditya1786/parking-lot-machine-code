package com.aditya.service;

import com.aditya.model.slot.ParkingSlot;
import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.model.ticket.ParkingExitTicket;
import com.aditya.repo.ParkingEntryTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ParkingEntryTicketService {
    private final ParkingEntryTicketRepository parkingEntryTicketRepository;

    public ParkingEntryTicketService(ParkingEntryTicketRepository parkingEntryTicketRepository) {
        this.parkingEntryTicketRepository = parkingEntryTicketRepository;
    }

    public ParkingEntryTicket createTicket(String vehicleId, ParkingSlot parkingSlot) {
        String id = "parking-entry-" + parkingEntryTicketRepository.getAll().size();
        ParkingEntryTicket parkingEntryTicket = new ParkingEntryTicket(
                id,
                vehicleId,
                parkingSlot
        );
        parkingEntryTicketRepository.save(parkingEntryTicket);
        return parkingEntryTicket;
    }

    public ParkingEntryTicket getById(Map<String,String> filters){
        if(filters.containsKey("id") && parkingEntryTicketRepository.getById(filters.get("id")) != null){
            return parkingEntryTicketRepository.getById(filters.get("id"));
        } else {
            List<ParkingEntryTicket> allTickets = parkingEntryTicketRepository.getAll();
            for(ParkingEntryTicket ticket: allTickets) {
                if(filters.containsKey("vehicleId")){
                    if(ticket.getVehicleId().equals(filters.get("vehicleId"))){
                        return ticket;
                    }
                } if(filters.containsKey("parkingSlotId")) {
                    if(ticket.getParkingSlot().getSlotId().equals(filters.get("parkingSlotId"))){
                        return ticket;
                    }
                }
            }
        }
        throw new NoSuchElementException("No filter matched for entry ticket");
    }

    public void resolve(String id){
        ParkingEntryTicket parkingEntryTicket = parkingEntryTicketRepository.getById(id);
        parkingEntryTicket.setPaid(true);
    }

}
