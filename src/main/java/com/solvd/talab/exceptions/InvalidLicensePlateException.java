package com.solvd.talab.exceptions;

public class InvalidLicensePlateException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid character";
    }
}