package com.solvd.talab;

import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.generics.GenericLinkedList;
import com.solvd.talab.models.Car;
import com.solvd.talab.models.CarWash;
import com.solvd.talab.models.Motorbike;
import com.solvd.talab.models.Vehicle;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class App 
{
    public static void main( String[] args )
    {


        Vehicle v1 = null;
        Motorbike v2 = null;
        Car v3 = null;
        Vehicle v4 = null;
        try {
            v1 = new Car("AA123AA","Ford",180,"Diesel");
            v2 = new Motorbike("BB456BB","Honda",160,"Cross");
            v3 = new Car("CC789CC","Toyota",230,"Diesel");
            v4 = v1;
        } catch (InvalidCharacter e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }


        LOGGER.log(Level.INFO, "HELLO");
        CarWash carWash = new CarWash("SuperWash","Street 123");

        carWash.addVehicle(v1);
        carWash.addVehicle(v2);
        carWash.addVehicle(v3);
        carWash.washVehicle();


        System.out.println( carWash.toString());
    }
}
