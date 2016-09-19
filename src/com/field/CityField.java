package com.field;

public class CityField extends Field {
    public CityField(CityFieldType type) {
        this.name = type.getName();
    }
}