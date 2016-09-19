package com.field;

public class FieldFactory {
    public Field getField(FieldType type) {
        if (type instanceof CountryFieldType) {
            return new CountryField((CountryFieldType) type);
        }
        if (type instanceof PercentFieldType) {
            return new PercentField((PercentFieldType) type);
        }
        if (type instanceof MoneyFieldType) {
            return new MoneyField((MoneyFieldType) type);
        }
        if (type instanceof CityFieldType) {
            return new CityField((CityFieldType) type);
        }
        if (type instanceof PortFieldType) {
            return new PortField((PortFieldType) type);
        }
        throw new IllegalArgumentException();
    }
}