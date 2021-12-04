package com.solvd.talab.models;

import com.solvd.talab.interfaces.SpeedProcessor;

import java.util.ArrayList;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class VehicleDealership {
    private String name;
    private String address;
    private ArrayList<Vehicle> vehicles;
    private float earnings;

    public VehicleDealership(String name, String address) {
        this.name = name;
        this.earnings = 0;
        this.address = address;
        this.vehicles = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public float getEarnings() {
        return earnings;
    }

    public ArrayList<Car> getCarsCatalog() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                cars.add((Car) v);
            }
        }
        return cars;
    }

    public ArrayList<Motorbike> getMotorbikeCatalog() {
        ArrayList<Motorbike> motos = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v instanceof Motorbike) {
                motos.add((Motorbike) v);
            }
        }
        return motos;
    }

    public void buyVehicle(Vehicle newV) {
        this.vehicles.add(newV);
    }

    public void sellVehicle(Vehicle vehicle, float price) {
        this.vehicles.remove(vehicle);
        this.earnings += price;
    }

    public void printCatalog(String vehicleType) {

        if (vehicleType.matches("Car")) {
            ArrayList<Car> vehicles = this.getCarsCatalog();
            for (Car cars : vehicles) {
                LOGGER.log(Level.INFO, cars.toString());
            }
        } else if (vehicleType.matches("Motorbike")) {
            ArrayList<Motorbike> vehicles = this.getMotorbikeCatalog();
            for (Motorbike motos : vehicles) {
                LOGGER.log(Level.INFO, motos.toString());
            }
        } else {
            LOGGER.log(Level.WARNING, "Vehicle type doesn't exists.");
        }
    }


    @Override
    public String toString() {
        return "CarDealership name: " + name +
                ", address:" + address +
                ", earnings:" + earnings +
                ", count of vehicles:" + vehicles.size();
    }

    //Lecture 8 lambdas functions
    public float fasterVehicle(float speed, float kilometers, SpeedProcessor processor) {
        return processor.avgSpeed(speed, kilometers);
    }

}
