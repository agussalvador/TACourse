package com.solvd.talab.exceptions;

public class NegativeSpeedException extends RuntimeException{
    @Override
    public String getMessage() {
        return ("The speed must be grater than 0");
    }
}