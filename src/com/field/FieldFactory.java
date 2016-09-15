package com.field;

public class FieldFactory {
    public Field getField(FieldType type) {
        if (type.equals(FieldType.COUNTRY)) {
            return new CountryField();
        }
        if (type.equals(FieldType.PERCENT)) {
            return new PercentField();
        }
        if (type.equals(FieldType.MONEY)) {
            return new MoneyField();
        }
        if (type.equals(FieldType.CITY)) {
            return new CityField();
        }
        if (type.equals(FieldType.PORT)) {
            return new PortField();
        }
        return null;
    }
}