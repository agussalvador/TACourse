package com.solvd.talab.models;

import com.solvd.talab.enums.CarWashType;
import com.solvd.talab.generics.GenericLinkedList;
import com.solvd.talab.interfaces.WashProcessor;

public class CarWash {
    private String name;
    private String address;
    private Enum<CarWashType> type;
    //Queue works with FIFO(First in first out) we insert new vehicles at the end of the queue.
    private GenericLinkedList<Vehicle> vehicleQueue;

    public CarWash(String name, String address, Enum<CarWashType> type) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.vehicleQueue = new GenericLinkedList<Vehicle>();
    }

    public CarWash(String name, String address) {
        this.name = name;
        this.address = address;
        this.vehicleQueue = new GenericLinkedList<Vehicle>();
    }

    public GenericLinkedList<Vehicle> getVehicleQueue() {
        return vehicleQueue;
    }

    public Enum<CarWashType> getType() {
        return type;
    }

    public void addVehicle(Vehicle newVehicle) {
        vehicleQueue.insert(newVehicle);
    }

    public void washVehicle() {
        vehicleQueue.deleteFirst();
    }

    @Override
    public String toString() {
        return "CarWash name: " + name + " ,address: " + address + " ,queue length: " + vehicleQueue.length() + "type: " + type;
    }

    public float wash(float time, WashProcessor washProcessor) {
        float price = washProcessor.wash(time);
        return price;
    }

}
