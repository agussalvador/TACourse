package com.solvd.talab.runners;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.enums.CarWashType;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.models.Car;
import com.solvd.talab.models.CarWash;

import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Lecture8EnumsLambda {
    public static void main(String[] args) {
        CarWash carWash1 = new CarWash("Deluxe wash","Street 123",CarWashType.FULL_SERVICE);
        Car ford;
        Car fiat;
        try {
            ford = new Car("AA123AA",220, CarEngineType.COMBUSTION, CarModel.FORD);
            fiat = new Car("BB567NA",190, CarEngineType.COMBUSTION, CarModel.FIAT);
            carWash1.addVehicle(ford);
            carWash1.addVehicle(fiat);
        } catch (InvalidCharacter e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }

        for (int i=0; i< carWash1.getVehicleQueue().length(); i++){
            carWash1.wash(()->CarWashType.FULL_SERVICE.getPrice());
        }


    }
}
