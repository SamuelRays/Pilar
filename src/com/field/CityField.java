package com.field;

public class CityField implements Field {
    private String name;
    private int amount;

    public CityField(CityFieldType type) {
        this.name = type.getName();
        this.amount = type.getAmount();
    }
}