package com.solvd.talab.exceptions;

public class InvalidFormat extends InvalidLicensePlateException {
    @Override
    public String getMessage() {
        return "Invalid format in license plate";
    }
}
