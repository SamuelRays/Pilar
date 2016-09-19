package com.field;

public enum CityFieldType implements FieldType {
    NEGATIVE_CITY_BONUS("Negative City Bonus", -1),
    POSITIVE_BONUS_MAX("Positive City Bonus", 1);

    private String name;
    private int amount;

    CityFieldType(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
