package com.solvd.talab.models;


import java.util.LinkedHashMap;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Garage {
    private String name;
    private String address;
    private int maxPlaces;
    private LinkedHashMap<Integer, Vehicle> vehicles;

    public Garage(String name, String address, int maxPlaces) {
        this.name = name;
        this.address = address;
        this.maxPlaces = maxPlaces;
        this.vehicles = new LinkedHashMap<>();
    }

    public void parkingVehicle(Vehicle vehicle, int parkingPlace) {
        if (parkingPlace <= maxPlaces)
            this.vehicles.put(parkingPlace, vehicle);
        else
            LOGGER.log(Level.INFO, "Garage limits places is: " + maxPlaces);
    }

    public Vehicle unparkVehicle(int parkingPlace) {
        return this.vehicles.remove(parkingPlace);
    }

    public int countParkVehicles() {
        return this.vehicles.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Garage name:" + name +
                ", address:" + address +
                ", maxPlaces:" + maxPlaces +
                ", count of vehicles parked: " + vehicles.size();
    }
}
