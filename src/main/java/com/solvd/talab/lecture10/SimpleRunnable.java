package com.solvd.talab.lecture10;

import com.solvd.talab.exceptions.ConnectionLimitException;

import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class SimpleRunnable implements Runnable {
    public String name;

    public SimpleRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Client.createConnection(this.name);
        } catch (ConnectionLimitException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
}
