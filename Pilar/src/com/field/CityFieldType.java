package com.field;

public enum CityFieldType implements FieldType {
    NEGATIVE_CITY_BONUS("Negative City Bonus"),
    POSITIVE_CITY_BONUS("Positive City Bonus");

    private String name;

    CityFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
