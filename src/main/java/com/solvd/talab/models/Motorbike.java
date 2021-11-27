package com.solvd.talab.models;

import com.solvd.talab.enums.MotorbikeType;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.exceptions.NegativeSpeedException;
import com.solvd.talab.interfaces.IStunts;

public class Motorbike extends Vehicle implements IStunts {
    private Enum<MotorbikeType> bikeType;


    public Motorbike(String licensePlate, float maxSpeed, Enum<MotorbikeType> bikeType) throws NegativeSpeedException, InvalidCharacter {
        super(licensePlate,maxSpeed);
        this.bikeType = bikeType;
    }

    @Override
    public void wheelie() {
        System.out.println("The bike its doing wheelie, be careful");
    }

    @Override
    public void jumpingRamp() {
        System.out.println("The biker is crazy and is jumping a ramp.");
    }

    @Override
    public void run() {
        System.out.println("The " + bikeType + " motorbike its running");
    }

    public void run(float speed) {
        System.out.println("the motorbike is running at: " + speed + "km/h");
    }

    @Override
    public void stop() {
        System.out.println("The " + bikeType + " motorbike was stopped");
    }

    public Enum<MotorbikeType> getBikeType() {
        return bikeType;
    }

    public void setBikeType(Enum<MotorbikeType> bikeType) {
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", bikeType='" + bikeType + '\'';
    }

    @Override
    public void changeWheels(int wheels) {
        System.out.println("the motorbike has" + wheels + " new wheels");
    }


}
