package com.aditya.repo;

import com.aditya.model.vehicle.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepository {
    private final Map<String, Vehicle> vehicleMap;

    public VehicleRepository() {
        vehicleMap = new LinkedHashMap<>();
    }

    public void save(Vehicle vehicle){
        vehicleMap.put(vehicle.getId(), vehicle);
    }

    public void remove(Vehicle vehicle) {
        vehicleMap.remove(vehicle.getId());
    }

    public Vehicle getById(String id){
        return vehicleMap.get(id);
    }

    public List<Vehicle> getAll() {
        return vehicleMap.values().stream().toList();
    }
}
