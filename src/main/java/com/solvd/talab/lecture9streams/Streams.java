package com.solvd.talab.lecture9streams;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.models.Car;
import com.solvd.talab.models.Vehicle;
import com.solvd.talab.models.VehicleDealership;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Streams {
    public static void main(String[] args) {
        //Create a Vehicle dealearship
        VehicleDealership fordOficial = new VehicleDealership("Ford Oficial", "Street 123");
        Car ford1 = null;
        Car ford2 = null;
        Car fiat = null;
        try {
            ford1 = new Car("aA123AA", 220, 52040f, CarEngineType.COMBUSTION, CarModel.FORD);
            ford2 = new Car("cc193fr", 240, 23400f, CarEngineType.ELECTRIC, CarModel.FORD);
            fiat = new Car("BE567NA", 190, 40000f, CarEngineType.COMBUSTION, CarModel.FIAT);
            //Adding cars to lists
            fordOficial.buyVehicle(ford1);
            fordOficial.buyVehicle(ford2);
        } catch (InvalidCharacter e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }


        //Stream declarations

        Stream<Car> vehiclesKilometers = fordOficial.getCarsCatalog().stream();
        Stream<Car> runVehicles = fordOficial.getCarsCatalog().stream();
        Stream<Car> minKilometers = fordOficial.getCarsCatalog().stream();
        Stream<Car> maxKilometers = fordOficial.getCarsCatalog().stream();
        Stream<Car> countElements = fordOficial.getCarsCatalog().stream();
        Stream<Car> filterStream = fordOficial.getCarsCatalog().stream();
        Stream<Car> peekStream = fordOficial.getCarsCatalog().stream();

        //Streams with terminal operations
        runVehicles.forEach(car -> car.run(40));
        LOGGER.log(Level.INFO, "Minim kilometers car: " + minKilometers.min(Comparator.comparingDouble(Vehicle::getKilometers)));
        LOGGER.log(Level.INFO, "Maxim kilometers car: " + maxKilometers.max(Comparator.comparingDouble(Vehicle::getKilometers)));
        LOGGER.log(Level.INFO, "Count of elements: " + countElements.count());

        //Streams with non-terminal operations
        peekStream.filter(c -> c.getLicensePlate().startsWith("A"))
                .peek(e -> LOGGER.log(Level.INFO, "Cars license plate starts with a: " + e))
                .collect(Collectors.toList());
        Stream<Car> newCars = filterStream.filter(car -> car.getKilometers() == 0);
        LOGGER.log(Level.INFO, "Kilometers sum: " + vehiclesKilometers.mapToDouble(w -> w.getKilometers()).sum());


    }

}
