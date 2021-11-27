package com.solvd.talab.models;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.exceptions.NegativeSpeedException;

public class Car extends Vehicle {


    private Enum<CarEngineType> engine;
    private Enum<CarModel> model;

    public Car(String licensePlate, float maxSpeed, Enum<CarEngineType> engine, Enum<CarModel> model) throws NegativeSpeedException, InvalidCharacter {
        super(licensePlate, maxSpeed);
        this.engine = engine;
        this.model = model;
    }

    public Enum<CarEngineType> getEngine() {
        return engine;
    }

    public void setEngine(Enum<CarEngineType> engine) {
        this.engine = engine;
    }

    public Enum<CarModel> getModel() {
        return model;
    }

    public void setModel(Enum<CarModel> model) {
        this.model = model;
    }

    public void reverse() {
        System.out.println("The car its making reverse, use your rear-view mirrors");
    }

    //Override methods
    @Override
    public void run() {
        System.out.println("The " + engine + " car its running");
    }

    public void run(float speed) {
        System.out.println("the car is running at: " + speed + "km/h");
    }

    @Override
    public void stop() {
        System.out.println("The " + engine + " car was stopped");
    }

    @Override
    public void changeWheels(int wheels) {
        System.out.println("the car has" + wheels + " new wheels");
    }
}

