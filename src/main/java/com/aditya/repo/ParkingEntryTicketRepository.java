package com.aditya.repo;

import com.aditya.model.ticket.ParkingEntryTicket;
import com.aditya.model.ticket.ParkingExitTicket;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ParkingEntryTicketRepository {
    Map<String, ParkingEntryTicket> parkingEntryTicketMap;

    public ParkingEntryTicketRepository() {
        this.parkingEntryTicketMap = new LinkedHashMap<>();
    }

    public void save(ParkingEntryTicket parkingEntryTicket){
        parkingEntryTicketMap.put(parkingEntryTicket.getId(), parkingEntryTicket);
    }

    public void remove(ParkingEntryTicket parkingEntryTicket){
        parkingEntryTicketMap.remove(parkingEntryTicket.getId());
    }
    public ParkingEntryTicket getById(String id){
        return parkingEntryTicketMap.get(id);
    }

    public List<ParkingEntryTicket> getAll() {
        return parkingEntryTicketMap.values().stream().toList();
    }
}
