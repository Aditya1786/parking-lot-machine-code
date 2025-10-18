package com.aditya.model.ticket;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParkingExitTicket {
  private final String id;
  private final String vehicleId;
  private final String parkingEntryTicketId;
  private final Duration parkingDuration;
  private final double amount;
}
