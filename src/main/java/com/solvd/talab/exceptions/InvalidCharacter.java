package com.solvd.talab.exceptions;

public class InvalidCharacter extends InvalidLicensePlateException{
    @Override
    public String getMessage() {
        return "Invalid character in license plate";
    }
}
