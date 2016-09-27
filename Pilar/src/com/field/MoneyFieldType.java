package com.field;

public enum MoneyFieldType implements FieldType {
    TAX("Tax"),
    FORWARD("Forward");

    private String name;

    MoneyFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
