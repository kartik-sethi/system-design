package io.github.kartiksethi.vehicle;

import io.github.kartiksethi.enums.VehicleStatus;
import io.github.kartiksethi.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleInventoryManager {

    private final Map<Integer, Vehicle> vehicles = new HashMap<>();
    private final Map<Integer, ReentrantLock> vehicleLocks = new HashMap<>();

    public VehicleInventoryManager() {}

    public Vehicle getById(int vehicleId){
        Vehicle vehicle =  vehicles.get(vehicleId);
        if(vehicle == null){
            throw new RuntimeException("No vehicle found with id:"+vehicleId);
        }
        return vehicle;
    }

    public Vehicle reserveVehicle(int vehicleId){
        ReentrantLock lock = vehicleLocks.get(vehicleId);
        
        lock.lock();
        try {
            if(!isVehicleAvailable(vehicleId)){
                throw new RuntimeException("Vehicle is not available "+vehicleId);
            }
            Vehicle vehicle = getById(vehicleId);
            vehicle.setVehicleStatus(VehicleStatus.RESERVED);
            return vehicle;
        } finally {
            lock.unlock();
        }
    }

    public boolean isVehicleAvailable(int vehicleId){
        return getById(vehicleId).getVehicleStatus() == VehicleStatus.AVAILABLE;
    }

    public Vehicle addVehicle(String number){
        int vehicleId = (int) (Math.random() * 10000);
        Vehicle vehicle = new Vehicle(vehicleId, number, VehicleType.FOUR_WHEELER, VehicleStatus.AVAILABLE);
        vehicles.put(vehicleId, vehicle);
        vehicleLocks.put(vehicleId, new ReentrantLock());
        return vehicle;
    }

    public Vehicle removeVehicle(int vehicleId){
        Vehicle vehicle = getById(vehicleId);
        vehicle.setVehicleStatus(VehicleStatus.UNDER_MAINTENANCE);
        return vehicle;
    }
}
