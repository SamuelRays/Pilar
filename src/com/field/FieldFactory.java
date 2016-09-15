package com.field;

public class FieldFactory {
    public Field getField(FieldType type, Object... obj) {
        if (type.equals(FieldType.COUNTRY) && obj.length == 1 && obj[0] instanceof Country) {
            return new CountryField((Country)obj[0]);
        }
        if (type.equals(FieldType.PERCENT) && obj.length == 2 && obj[0] instanceof String && obj[1] instanceof Float) {
            return new PercentField((String)obj[0], (Float)obj[1]);
        }
        if (type.equals(FieldType.MONEY) && obj.length == 2 && obj[0] instanceof String && obj[1] instanceof Integer) {
            return new MoneyField((String)obj[0], (Integer)obj[1]);
        }
        if (type.equals(FieldType.CITY) && obj.length == 2 && obj[0] instanceof String && obj[1] instanceof Integer) {
            return new CityField((String)obj[0], (Integer)obj[1]);
        }
        if (type.equals(FieldType.PORT) && obj.length == 0) {
            return new PortField();
        }
        throw new IllegalArgumentException();
    }
}