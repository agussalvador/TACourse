package com.solvd.talab.enums;

public enum CarModel {
    FORD(Country.USA),
    FIAT(Country.ITALY),
    RENAULT(Country.FRANCE),
    FERRARI(Country.ITALY);

    private Enum<Country> country;

    CarModel(Enum<Country> country) {
        this.country = country;
    }

    public Enum<Country> getCountry() {
        return country;
    }
}
