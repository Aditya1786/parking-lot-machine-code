package com.aditya.repo;

import com.aditya.model.ticket.ParkingExitTicket;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingExitTicketRepository {
  Map<String, ParkingExitTicket> parkingExitTicketMap;

  public ParkingExitTicketRepository() {
    parkingExitTicketMap = new LinkedHashMap<>();
  }

  public void save(ParkingExitTicket parkingExitTicket) {
    parkingExitTicketMap.put(parkingExitTicket.getId(), parkingExitTicket);
  }

  public void remove(ParkingExitTicket parkingExitTicket) {
    parkingExitTicketMap.remove(parkingExitTicket.getId());
  }

  public ParkingExitTicket getById(String id) {
    return parkingExitTicketMap.get(id);
  }

  public List<ParkingExitTicket> getAll() {
    return parkingExitTicketMap.values().stream().toList();
  }
}
