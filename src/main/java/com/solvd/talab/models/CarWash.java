package com.solvd.talab.models;

import com.solvd.talab.generics.GenericLinkedList;

public class CarWash {
    private String name;
    private String address;
    //Queue works with FIFO(First in first out) we insert new vehicles at the end of the queue.
    private GenericLinkedList<Vehicle> vehicleQueue;

    public CarWash(String name, String address) {
        this.name = name;
        this.address = address;
        this.vehicleQueue = new GenericLinkedList<Vehicle>();
    }

    public GenericLinkedList<Vehicle> getVehicleQueue() {
        return vehicleQueue;
    }

    public void addVehicle(Vehicle newVehicle) {
        vehicleQueue.insert(newVehicle);
    }

    public void washVehicle() {
        vehicleQueue.deleteFirst();
    }

    @Override
    public String toString() {
        return "CarWash name: " + name + " ,address: " + address + " ,queue length: " + vehicleQueue.length();
    }
}
