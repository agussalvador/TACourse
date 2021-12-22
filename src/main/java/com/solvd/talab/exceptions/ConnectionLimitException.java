package com.solvd.talab.exceptions;

public class ConnectionLimitException extends Exception {
    @Override
    public String getMessage() {
        return "Limit of threads";
    }
}
