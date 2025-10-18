package com.aditya.service;

import com.aditya.model.vehicle.Vehicle;
import com.aditya.model.vehicle.VehicleType;
import com.aditya.repo.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(String ownerName, String vehicleNumber, String licenseNumber, VehicleType vehicleType) {
        String id = "vehicle-" + (vehicleRepository.getAll().size());
        Vehicle vehicle = new Vehicle(id, ownerName, vehicleNumber, vehicleType, licenseNumber);
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.getById(id);
    }

    public void removeVehicle(String id) {
        Vehicle vehicle = vehicleRepository.getById(id);
        vehicleRepository.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.getAll();
    }
}
