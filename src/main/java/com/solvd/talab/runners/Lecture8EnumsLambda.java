package com.solvd.talab.runners;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.enums.CarWashType;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.models.Car;
import com.solvd.talab.models.CarWash;
import com.solvd.talab.models.Vehicle;
import com.solvd.talab.models.VehicleDealership;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.Arrays;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Lecture8EnumsLambda {
    public static void main(String[] args) {
        //Create a car wash and a Vehicle dealearship
        CarWash carWash1 = new CarWash("Deluxe wash", "Street 123", CarWashType.SELF_SERVICE);
        VehicleDealership fordOficial = new VehicleDealership("Ford Oficial", "Street 123");
        Car ford1 = null;
        Car ford2 = null;
        Car fiat = null;
        try {
            ford1 = new Car("aA123AA", 220, 52040f, CarEngineType.COMBUSTION, CarModel.FORD);
            ford2 = new Car("cc193fr", 240, 23400f, CarEngineType.ELECTRIC, CarModel.FORD);
            fiat = new Car("BB567NA", 190, 40000f, CarEngineType.COMBUSTION, CarModel.FIAT);
            //Adding cars to lists
            carWash1.addVehicle(ford1);
            carWash1.addVehicle(fiat);
            fordOficial.buyVehicle(ford1);
            fordOficial.buyVehicle(ford2);
        } catch (InvalidCharacter e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }


        //Custom lambda functions
        for (int i = 0; i < carWash1.getVehicleQueue().length(); i++) {
            //Price will be different depending on the time used for wash the car.
            LOGGER.log(Level.INFO, "Wash price is: " +
                    carWash1.wash(1.3f + (float) i, (time) -> CarWashType.SELF_SERVICE.getPrice() * time));
        }
        //Faster car
        for (Car c : fordOficial.getCarsCatalog()) {
            LOGGER.log(Level.INFO, "License plate: " + c.getLicensePlate() + " average speed: " +
                    fordOficial.fasterVehicle(c.getMaxSpeed(), c.getKilometers(), (speed, km) -> km / speed));
        }

        //java.util.function
        //In class vehicle at the constructor I use interface Function<T,R> on "formatLicensePlate" method
        LOGGER.log(Level.INFO, "BiFunction usage: " +
                process("Example lambda function", 7, (str, i) -> str.substring(i)));

        //Concat Model with license plate
        for (Car c : fordOficial.getCarsCatalog()) {
            LOGGER.log(Level.INFO, concat("-" + c.getLicensePlate(), c.getModel().name()::concat));
            biConsumer(CarModel.FORD.getCountry().toString(), c.getModel().toString(),
                    (ctry, model) -> LOGGER.log(Level.INFO, c + model.concat(ctry)));
        }


    }

    private static void biConsumer(String country, String model, BiConsumer<String, String> processor) {
        processor.accept(country, model);
    }

    private static String process(String str, int i, BiFunction<String, Integer, String> processor) {
        return processor.apply(str, i);
    }

    private static String concat(String str, Function<String, String> processor) {
        return processor.apply(str);
    }
}
