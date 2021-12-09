package com.solvd.talab.lecture10;

import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Connection {

    public Connection(String name) {
        LOGGER.log(Level.INFO, "New connection name: " + name);
    }

}
