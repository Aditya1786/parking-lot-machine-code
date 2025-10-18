package com.aditya.model.floor;

import com.aditya.model.slot.ParkingSlot;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParkingFloor {
  private final String floorId;
  private final List<ParkingSlot> parkingSlotList;
  private boolean isFull;
}
