package com.field;

public class CityField extends Field {
    public CityField(CityFieldType type) {
        this.type = type;
        this.name = type.getName();
    }
}