package com.solvd.talab.enums;

public enum CarWashType {
    SELF_SERVICE(5.5f),
    AUTOMATIC(8f),
    FULL_SERVICE(10f);

    private float price;

    private CarWashType(float price) {
        this.price = price;
    }
    public float getPrice() {
        return price;
    }
}
