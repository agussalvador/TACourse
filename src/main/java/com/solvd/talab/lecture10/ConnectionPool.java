package com.solvd.talab.lecture10;

import com.solvd.talab.exceptions.ConnectionLimitException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class ConnectionPool {
    private final int limitConnections;
    private final Map<String, Connection> concurrentMap;
    private static ConnectionPool instance;

    //Singleton
    private ConnectionPool(int limitThreads) {
        this.limitConnections = limitThreads;
        this.concurrentMap = new ConcurrentHashMap<String, Connection>();

    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(4);
        }
        return instance;
    }

    public synchronized Connection connect(String name) throws ConnectionLimitException {
        //print some outputs, connect to database
        // Return connection object or throw exception about unavailable connection in case of limit of thread
        if (concurrentMap.size() < limitConnections) {
            Connection connection = new Connection(name);
            concurrentMap.put(name, connection);
            return connection;
        } else {
            throw new ConnectionLimitException();
        }

    }

    public Boolean isFull() {
        return getConcurrentMapSize() >= limitConnections;
    }

    public int getConcurrentMapSize() {
        return concurrentMap.size();
    }

    public synchronized void disconnect(String name) {
        LOGGER.log(Level.INFO, "Connection finished value: " + name);
        concurrentMap.remove(name);
        //remove the connection value on the map and one available connection will be appeared.
    }
}
