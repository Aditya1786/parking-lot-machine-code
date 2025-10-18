package com.aditya.model.ticket;

import com.aditya.model.slot.ParkingSlot;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
public class ParkingEntryTicket {
    private final String id;
    private final String vehicleId;
    private final ParkingSlot parkingSlot;
    private final LocalTime entryTime;
    private boolean isPaid;

    public ParkingEntryTicket(String id, String vehicleId, ParkingSlot parkingSlot) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.parkingSlot = parkingSlot;
        entryTime = LocalTime.now();
        isPaid = false;
    }

}
