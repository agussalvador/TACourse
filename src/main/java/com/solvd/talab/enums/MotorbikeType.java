package com.solvd.talab.enums;

public enum MotorbikeType {
    CROSS("Off-Road"),
    RALLY("Off-Road"),
    CHOPPER("Smooth"),
    SPORT("Smooth"),
    TOURING("Smooth"),
    SCOOTER("Smooth");

    private String tiresType;

    MotorbikeType(String tiresType) {
        this.tiresType = tiresType;
    }

    public String getTiresType() {
        return tiresType;
    }
}
