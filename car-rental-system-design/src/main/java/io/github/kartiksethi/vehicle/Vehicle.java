package io.github.kartiksethi.vehicle;

import io.github.kartiksethi.enums.VehicleStatus;
import io.github.kartiksethi.enums.VehicleType;

public class Vehicle {
    
    private final int id;
    private final String number;
    private final VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private double cost;
    
    public Vehicle(int id, String number, VehicleType vehicleType, VehicleStatus vehicleStatus) {
        this.id = id;
        this.number = number;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

}
