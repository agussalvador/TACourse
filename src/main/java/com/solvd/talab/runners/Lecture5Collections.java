package com.solvd.talab.runners;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.enums.MotorbikeType;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.models.*;

import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Lecture5Collections {
    public static void main(String[] args) {
        Garage garage1 = new Garage("Center Garage", "Street 123", 50);
        CarWash carWash1 = new CarWash("Premium Wash", "Street 987");
        VehicleDealership vehicleDealership1 = new VehicleDealership("Ford Oficial", "Street 567");

        Vehicle v1 = null;
        Motorbike v2 = null;
        Car v3 = null;
        Vehicle v4 = null;
        Car ford1 = null;
        Car ford2 = null;

        try {
            v1 = new Car("AA123AA", 180, CarEngineType.COMBUSTION, CarModel.FORD);
            v2 = new Motorbike("BB456BB",  160, MotorbikeType.CROSS);
            v3 = new Car("CC789CC",  230, CarEngineType.COMBUSTION,CarModel.RENAULT);
            v4 = v1;
            ford1 = new Car("AA156FV",  190, CarEngineType.COMBUSTION,CarModel.FORD);
            ford2 = new Car("BG659FV",  197, CarEngineType.COMBUSTION,CarModel.FORD);

        } catch (InvalidCharacter e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }

        //Garage: Parking vehicles
        garage1.parkingVehicle(v1, 45);
        garage1.parkingVehicle(v2, 30);
        garage1.parkingVehicle(v3, 1);
        garage1.parkingVehicle(v4, 70);

        //Garage: Unpark vehicle
        garage1.unparkVehicle(45);

        //VehicleDealership ford add
        vehicleDealership1.buyVehicle(v1);
        vehicleDealership1.buyVehicle(ford1);
        vehicleDealership1.buyVehicle(ford2);

        //VehicleDealership ford sell
        vehicleDealership1.sellVehicle(v1, 55000);

        //VehicleDealership ford earnings
        LOGGER.log(Level.INFO, "Vehicle Dealership: " + vehicleDealership1.getName() + "Earnings: " + vehicleDealership1.getEarnings());
        //VehicleDealership ford catalog

        LOGGER.log(Level.INFO, "Vehicle Dealership: " + vehicleDealership1.getName() + " Catalog: ");
        vehicleDealership1.printCatalog("Car");


        //Generic LinkedList implementation. CarWash FIFO Queue
        carWash1.addVehicle(v1);
        carWash1.addVehicle(v2);
        carWash1.addVehicle(ford1);
        carWash1.addVehicle(ford2);
        LOGGER.log(Level.INFO, carWash1.toString());

        //First vehicle of the queue removed because it's clean!
        carWash1.washVehicle();
        LOGGER.log(Level.INFO, carWash1.toString());


    }
}
