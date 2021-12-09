package com.solvd.talab.lecture10;

import com.solvd.talab.exceptions.ConnectionLimitException;

import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class SimpleThread extends Thread {

    public SimpleThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        try {
            Client.createConnection(this.getName());
        } catch (ConnectionLimitException | InterruptedException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}
