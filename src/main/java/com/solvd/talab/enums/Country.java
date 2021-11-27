package com.solvd.talab.enums;

public enum Country {
    ARGENTINA("Argentinian"),
    ITALY("Italian"),
    JAPAN ("Japanese"),
    GERMANY("German"),
    FRANCE("French"),
    USA("North Americans"),
    CHINA("Chinese");

    private String demonym;

    Country(String demonym) {
        this.demonym = demonym;
    }

    public String getDemonym() {
        return demonym;
    }
}
